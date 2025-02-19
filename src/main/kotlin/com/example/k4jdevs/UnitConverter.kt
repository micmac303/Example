package com.example.k4jdevs

private const val YARDS_TO_METRES = 0.9144
private const val MILES_TO_METRES = 1609.34

fun main() {

    println("Enter an imperial length value and unit to be converted e.g. \"10 yards\"")
    val input: String? = readlnOrNull();

    val split = input?.split(" ")
    val value = split?.get(0)?.toDouble()
    val unit = split?.get(1)

    val converted =
        when (unit) {
            "yards" -> value?.times(YARDS_TO_METRES)
            "miles" -> value?.times(MILES_TO_METRES)
            else -> null
    }

    val output = value.toString() + " " + unit + " is " + converted + " meter(s)"

    println(output)
}