package com.packtpub.appendix

fun main(args: Array<String>) {
    val x:Int = 8

    when (x) {
        0 -> println("x is zero")
        1, 2 -> println("x is 1 or 2")
        in 3..5 -> println("x is between 3 and 5")
        else -> println("x is bigger than 5")
    }

    val message = when {
        2 > 1 -> "2 is greater than 1"
        else -> "This never gonna happen"
    }

    println(message)
}