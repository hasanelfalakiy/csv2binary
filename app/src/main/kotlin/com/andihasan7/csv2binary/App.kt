/*
 * This source file was generated by the Gradle 'init' task
 */
package com.andihasan7.csv2binary

import com.andihasan7.csv2binary.csv2bin.ConvertCsvToBinary
import com.andihasan7.csv2binary.readerbin.ReaderBin


fun main() {

    val csvFilePath = "/home/andihasan7/IdeaProjects/csv2binary/app/src/main/resources/data.csv"

    val binaryFilePath = "/home/andihasan7/IdeaProjects/csv2binary/app/src/main/resources/data.bin"
    val binaryName = "/data.bin"

    // convert csv to binary
    ConvertCsvToBinary.convertVsop87dCsvToBinary(csvFilePath, binaryFilePath)

    val totalCoefficients = ReaderBin.readVsop87dBinary(binaryName)
    println("Total Coefficients: $totalCoefficients")
}
