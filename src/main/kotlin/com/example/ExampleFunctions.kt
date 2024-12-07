package com.example

fun factorial(input: String): String {

    return try {
        val n = input.toInt()
        when {
            n < 0   -> "Please enter a non-negative number"
            n > 20  -> "Maximum value is 20"
            else    -> factorial(n).toString()
        }
    } catch (e: NumberFormatException) {
        "Invalid number format"
    }
}

fun factorial(n: Int): Long {

    return if (n <= 1) 1L
    else n * factorial(n - 1)
}

