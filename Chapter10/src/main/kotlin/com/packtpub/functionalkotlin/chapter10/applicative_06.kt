package com.packtpub.functionalkotlin.chapter10

fun main(args: Array<String>) {
    val add3AndMultiplyBy2: (Int) -> Pair<Int, Int> = { i:Int -> i + 3 }.ap { original -> { j:Int -> original to j * 2 } }
    println(add3AndMultiplyBy2(0)) //(0, 6)
    println(add3AndMultiplyBy2(1)) //(1, 8)
    println(add3AndMultiplyBy2(2)) //(2, 10)
}