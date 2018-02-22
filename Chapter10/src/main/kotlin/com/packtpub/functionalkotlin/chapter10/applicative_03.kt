package com.packtpub.functionalkotlin.chapter10

fun main(args: Array<String>) {
    val maybeFive = Option.pure(5)
    val maybeTwo = Option.pure(2)

    println(Option.pure { f: Int -> { t: Int -> f + t } } `(*)` maybeFive `(*)` maybeTwo) // Some(value=7)
}
