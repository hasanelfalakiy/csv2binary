package com.andihasan7.csv2binary.csv2bin

import com.andihasan7.csv2binary.dataclass.Vsop87dCsvRow
import com.esotericsoftware.kryo.kryo5.Kryo
import com.esotericsoftware.kryo.kryo5.io.Output
import java.io.File
import java.io.FileOutputStream

object ConvertCsvToBinary {

    /**
     * function to convert vsop87d csv file to binary
     *
     * @param csvFilePath path of csv file
     * @param binaryFilePath path of binary file that you want
     */
    fun convertVsop87dCsvToBinary(csvFilePath: String, binaryFilePath: String) {

        val csvFile = File(csvFilePath)
        if (!csvFile.exists()) throw IllegalArgumentException("File $csvFilePath not found")

        val kryo = Kryo()
        kryo.register(Vsop87dCsvRow::class.java)

        val binaryFile = File(binaryFilePath)

        csvFile.bufferedReader(Charsets.UTF_8).use { reader ->
            Output(FileOutputStream(binaryFile)).use { output ->
                // skip header
                reader.readLine()
                // loop read csv and write to binary
                reader.lineSequence().forEach { line ->
                    val columns = line.split(",")
                    val vsop87dCsvRow = Vsop87dCsvRow(
                        i = columns[0].toInt(),
                        a = columns[1].toDouble(),
                        b = columns[2].toDouble(),
                        c = columns[3].toDouble()
                    )
                    kryo.writeObject(output, vsop87dCsvRow)
                }
            }
        }
        println("Successful saving data to binary: $binaryFilePath")
    }
}