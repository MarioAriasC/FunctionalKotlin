package com.packtpub.functionalkotlin.chapter10

fun main(args: Array<String>) {
    val numbers = listOf(1, 2, 3)
    val functions = listOf<(Int) -> Int>({ i -> i * 2 }, { i -> i + 3 })
    val result = numbers
            .ap(functions)
            .joinToString()
    println(result) //2, 4, 6, 4, 5, 6
}