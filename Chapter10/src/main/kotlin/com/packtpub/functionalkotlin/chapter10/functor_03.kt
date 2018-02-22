package com.packtpub.functionalkotlin.chapter10

fun main(args: Array<String>) {
    println(Option.Some("Kotlin").map(String::toUpperCase))
    println(Option.None.map(String::toUpperCase))
}
