package com.packtpub.functionalkotlin.chapter10

fun main(args: Array<String>) {
    val maybeFive = Option.Some(5)
    val maybeTwo = Option.Some(2)

    println(maybeFive.flatMap { f ->
        maybeTwo.map { t ->
            f + t
        }
    }) // Some(value=7)
}