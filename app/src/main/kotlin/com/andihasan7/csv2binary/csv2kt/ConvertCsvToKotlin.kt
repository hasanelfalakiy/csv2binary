/**
 * This file is part of csv2binary.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 * @programmed by: Andi Hasan A
 * @github: https://github.com/hasanelfalakiy
 */

package com.andihasan7.csv2binary.csv2kt

import java.io.File

object ConvertCsvToKotlin {

    /**
     * function to convert vsop87d csv file to kotlin file 2D or
     * Array<DoubleArray>
     *
     * @param resourcePath path of csv file
     * @param outputKtPath path of kotlin file output that you want
     */
    fun convertVsop87dCsvToKotlinArray(resourcePath: String, outputKtPath: String) {

        // read csv file as stream
        val inputStream = this::class.java.classLoader.getResourceAsStream(resourcePath)
            ?: throw IllegalArgumentException("Resource: $resourcePath not found")

        // read all lines from csv file
        val lines = inputStream.bufferedReader(Charsets.UTF_8).use { reader ->
            reader.readLines()
        }

        // convert csv lines to be doubleArrayOf (ignore header)
        val dataArrays = lines.drop(1).map { line ->
            val columns = line.split(",")
            doubleArrayOf(
                columns[1].toDouble(), // column A
                columns[2].toDouble(), // column B
                columns[3].toDouble() // column C
            )
        }

        // merge all doubleArrayOf to arrayOf
        val result = dataArrays.joinToString(",\n") { "doubleArrayOf(${it.joinToString(",")})" }
        val endResult = "arrayOf(\n$result\n)"

        val outputFile = File(outputKtPath)
        outputFile.writeText(endResult)
        println("Successful saving data to kotlin file: $outputFile")
    }

    /**
     * function to convert elpmpp02 csv file to kotlin file 2D or
     * Array<DoubleArray>
     *
     * @param resourcePath path of csv file
     * @param outputKtPath path of kotlin file output that you want
     */
    fun convertElpmpp02CsvToKotlinArray(resourcePath: String, outputKtPath: String) {

        // read csv file as stream
        val inputStream = this::class.java.classLoader.getResourceAsStream(resourcePath)
            ?: throw IllegalArgumentException("Resource: $resourcePath not found")

        // read all lines from csv file
        val lines = inputStream.bufferedReader(Charsets.UTF_8).use { reader ->
            reader.readLines()
        }

        val validLines = lines.filter { it.isNotBlank() && it.contains(",") }

        // convert csv lines to be doubleArrayOf (ignore header)
        val dataArrays = validLines.drop(1).map { line ->
            val columns = line.split(",")
            doubleArrayOf(
                columns[1].toDouble(), // column vVN
                columns[2].toDouble(), // column vA0
                columns[3].toDouble(), // column vA1
                columns[4].toDouble(), // column vA2
                columns[5].toDouble(), // column vA3
                columns[6].toDouble() // column vA4
            )
        }

    // merge all doubleArrayOf to arrayOf
    val result = dataArrays.joinToString(",\n") { "doubleArrayOf(${it.joinToString(",")})" }
    val endResult = "arrayOf(\n$result\n)"

    val outputFile = File(outputKtPath)
    outputFile.writeText(endResult)
    println("Successful saving data to kotlin file: $outputFile")
}

/**
 * function to convert nutation2000b csv file to kotlin file 2D or
 * Array<DoubleArray>
 *
 * @param resourcePath path of csv file
 * @param outputKtPath path of kotlin file output that you want
 */
fun convertNutation2000bCsvToKotlinArray(resourcePath: String, outputKtPath: String) {

    // read csv file as stream
    val inputStream = this::class.java.classLoader.getResourceAsStream(resourcePath)
        ?: throw IllegalArgumentException("Resource: $resourcePath not found")

    // read all lines from csv file
    val lines = inputStream.bufferedReader(Charsets.UTF_8).use { reader ->
        reader.readLines()
    }

    // convert csv lines to be doubleArrayOf (ignore header)
    val dataArrays = lines.drop(1).map { line ->
        val columns = line.split(",")
        doubleArrayOf(
            columns[1].toDouble(), // column vL
            columns[2].toDouble(), // column vL1
            columns[3].toDouble(), // column vF
            columns[4].toDouble(), // column vD
            columns[5].toDouble(), // column vOmega
            columns[6].toDouble(), // column vA
            columns[7].toDouble(), // column vA1
            columns[8].toDouble(), // column vA2
            columns[9].toDouble(), // column vB
            columns[10].toDouble(), // column vB1
            columns[11].toDouble() // column vB2
        )
    }

    // merge all doubleArrayOf to arrayOf
    val result = dataArrays.joinToString(",\n") { "doubleArrayOf(${it.joinToString(",")})" }
    val endResult = "arrayOf(\n$result\n)"

    val outputFile = File(outputKtPath)
    outputFile.writeText(endResult)
    println("Successful saving data to kotlin file: $outputFile")
}
}