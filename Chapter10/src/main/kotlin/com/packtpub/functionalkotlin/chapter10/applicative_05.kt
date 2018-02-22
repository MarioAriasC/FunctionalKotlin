package com.packtpub.functionalkotlin.chapter10

fun main(args: Array<String>) {
    val add3AndMultiplyBy2: (Int) -> Int = { i: Int -> i + 3 }.ap { { j: Int -> j * 2 } }
    println(add3AndMultiplyBy2(0)) //6
    println(add3AndMultiplyBy2(1)) //8
    println(add3AndMultiplyBy2(2)) //10
}