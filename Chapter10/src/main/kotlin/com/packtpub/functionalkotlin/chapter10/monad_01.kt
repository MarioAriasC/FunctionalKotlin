package com.packtpub.functionalkotlin.chapter10

fun main(args: Array<String>) {
    val result = listOf(1, 2, 3)
            .flatMap { i ->
                listOf(i * 2, i + 3)
            }
            .joinToString()

    println(result) //2, 4, 4, 5, 6, 6
}