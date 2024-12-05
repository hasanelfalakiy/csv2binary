package com.andihasan7.csv2binary.csv2bin

import com.esotericsoftware.kryo.kryo5.Kryo
import com.esotericsoftware.kryo.kryo5.io.Output
import java.io.File
import java.io.FileOutputStream

object ConvertCsvToBinary {

    /**
     * function to convert vsop87d csv file to binary 2D
     *
     * @param csvFilePath path of csv file
     * @param binaryFilePath path of binary file that you want
     */
    fun convertVsop87dCsvToBinary(csvFilePath: String, binaryFilePath: String) {

        val csvFile = File(csvFilePath)
        val binaryFile = File(binaryFilePath)
        if (!csvFile.exists()) throw IllegalArgumentException("File $csvFilePath not found")

        val kryo = Kryo()
        kryo.register(DoubleArray::class.java)
        kryo.register(Array<DoubleArray>::class.java)

        val dataList = mutableListOf<DoubleArray>()

        csvFile.bufferedReader().useLines { lines ->
            lines.drop(1).forEach { line ->

                val columns = line.split(",").map { it.toDoubleOrNull() ?: 0.0 }

                dataList.add(doubleArrayOf(columns[1], columns[2], columns[3])) // column A, B, C

            }
        }
        Output(FileOutputStream(binaryFile)).use { output ->
            kryo.writeObject(output, dataList.toTypedArray())
        }
        println("Successful saving data to binary: $binaryFilePath")
    }

    /**
     * function to convert elpmpp02 csv file to binary 2D
     *
     * @param csvFilePath path of csv file
     * @param binaryFilePath path of binary file that you want
     */
    fun convertElpmpp02CsvToBinary(csvFilePath: String, binaryFilePath: String) {

        val csvFile = File(csvFilePath)
        if (!csvFile.exists()) throw IllegalArgumentException("File $csvFilePath not found")

        val kryo = Kryo()
        kryo.register(DoubleArray::class.java)
        kryo.register(Array<DoubleArray>::class.java)

        val binaryFile = File(binaryFilePath)
        val dataList = mutableListOf<DoubleArray>()

        csvFile.bufferedReader().useLines { lines ->
            lines.drop(1).forEach { line ->

                try {
                    val columns = line.split(",").map { it.toDoubleOrNull() ?: 0.0 }

                    if (columns.size >= 7) {
                        dataList.add(
                            doubleArrayOf(
                                columns[1],
                                columns[2],
                                columns[3],
                                columns[4],
                                columns[5],
                                columns[6]
                            )
                        ) // column vVN, vA0, vA1, vA2, vA3, vA4
                    } else {
                        println("Invalid col siz: ${columns.size}")
                    }
                } catch (e: Exception) {
                    println("Invalid row: $line")
                }
            }
        }
        Output(FileOutputStream(binaryFile)).use { output ->
            kryo.writeObject(output, dataList.toTypedArray())
        }
        println("Successful saving data to binary: $binaryFilePath")
    }

    /**
     * function to convert nutation-2000b csv file to binary 2D
     *
     * @param csvFilePath path of csv file
     * @param binaryFilePath path of binary file that you want
     */
    fun convertNutation2000bCsvToBinary(csvFilePath: String, binaryFilePath: String) {

        val csvFile = File(csvFilePath)
        val binaryFile = File(binaryFilePath)
        if (!csvFile.exists()) throw IllegalArgumentException("File $csvFilePath not found")

        val kryo = Kryo()
        kryo.register(DoubleArray::class.java)
        kryo.register(Array<DoubleArray>::class.java)

        val dataList = mutableListOf<DoubleArray>()

        csvFile.bufferedReader().useLines { lines ->
            lines.drop(1).forEach { line ->

                val columns = line.split(",").map { it.toDoubleOrNull() ?: 0.0 }

                dataList.add(doubleArrayOf(columns[1], columns[2], columns[3], columns[4], columns[5], columns[6], columns[7], columns[8], columns[9], columns[10], columns[11])) // column vL, vL1, vF, vD, vOmega, vA, vA1, vA2, vB, vB1, vB2

            }
        }
        Output(FileOutputStream(binaryFile)).use { output ->
            kryo.writeObject(output, dataList.toTypedArray())
        }
        println("Successful saving data to binary: $binaryFilePath")
    }
}