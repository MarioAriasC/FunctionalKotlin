package com.packtpub.functionalkotlin.chapter10

fun main(args: Array<String>) {
    val maybeFive = Option.pure(5)
    val maybeTwo = Option.pure(2)

    println(maybeTwo.ap(maybeFive.map { f -> { t: Int -> f + t } })) // Some(value=7)
}