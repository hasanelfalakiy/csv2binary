package com.andihasan7.csv2binary.readerbin

import com.andihasan7.csv2binary.dataclass.Elpmpp02CsvRow
import com.andihasan7.csv2binary.dataclass.Nutation2000bCsvRow
import com.andihasan7.csv2binary.dataclass.Vsop87dCsvRow
import com.esotericsoftware.kryo.kryo5.Kryo
import com.esotericsoftware.kryo.kryo5.io.Input
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

object ReaderBin {

    /**
     * function to read earth lbr binary file and calculate the coefficients
     *
     * @param t is the same as jme Julian Millenium Ephemeris
     * @param resourcePath path of binary file
     *
     * @return totalCoefficients
     */
    fun earthLBRBinaryReader(t: Double, resourcePath: String): Double {

        val inputStream = this::class.java.getResourceAsStream(resourcePath) ?: throw IllegalArgumentException("Resource $resourcePath not found")

        val kryo = Kryo()
        kryo.register(Vsop87dCsvRow::class.java)
        var totalCoefficients = 0.0

        Input(inputStream).use { input ->
            while (input.available() > 0) {
                val row = kryo.readObject(input, Vsop87dCsvRow::class.java)
                // val coefficient = row.a + cos(Math.toRadians(row.b + row.c * 2.5) * Math.PI / 180)
                val coefficient = row.vA + cos(row.vB + row.vC * t)
                totalCoefficients += coefficient
            }
        }
        return totalCoefficients
    }

}