package com.packtpub.functionalkotlin.chapter10

fun main(args: Array<String>) {
    val f: (String) -> Int = Function1.pure(0)
    println(f("Hello,"))    //0
    println(f("World"))     //0
    println(f("!"))         //0
}

