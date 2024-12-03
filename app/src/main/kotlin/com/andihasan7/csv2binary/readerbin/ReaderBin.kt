package com.andihasan7.csv2binary.readerbin

import com.andihasan7.csv2binary.dataclass.Vsop87dCsvRow
import com.esotericsoftware.kryo.kryo5.Kryo
import com.esotericsoftware.kryo.kryo5.io.Input
import kotlin.math.cos

object ReaderBin {

    /**
     * function to read binary file and calculate the coefficients
     *
     * @param binaryFilePath path of binary file
     *
     * @return totalCoefficients
     */
    fun readVsop87dBinary(resourcePath: String): Double {

        val inputStream = this::class.java.getResourceAsStream(resourcePath) ?: throw IllegalArgumentException("Resource $resourcePath not found")

        val kryo = Kryo()
        kryo.register(Vsop87dCsvRow::class.java)
        var totalCoefficients = 0.0

        Input(inputStream).use { input ->
            while (input.available() > 0) {
                val row = kryo.readObject(input, Vsop87dCsvRow::class.java)
                val coefficients = row.a + cos(Math.toRadians(row.b + row.c * 2.5) * Math.PI / 180)
                totalCoefficients += coefficients
            }
        }
        return totalCoefficients
    }
}