package com.packtpub.functionalkotlin.chapter10


fun main(args: Array<String>) {
    listOf(1, 2, 3)
            .map { i -> i * 2 }
            .map(Int::toString)
            .forEach(::println)
}