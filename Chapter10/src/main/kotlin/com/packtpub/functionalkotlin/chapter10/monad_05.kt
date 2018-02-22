package com.packtpub.functionalkotlin.chapter10

fun main(args: Array<String>) {
    val numbers = listOf(1, 2, 3)
    val functions = listOf<(Int) -> Int>({ i -> i * 2 }, { i -> i + 3 })
    val result = numbers.flatMap { number ->
        functions.map { f -> f(number) }
    }.joinToString()

    println(result) //2, 4, 4, 5, 6, 6
}