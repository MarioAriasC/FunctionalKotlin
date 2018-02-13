package com.rivuchk.packtpub.functionalkotlin.chapter08

fun main(args: Array<String>) {
    val list = listOf(10,20,30)

    val flatMappedList = list.flatMap {
        it.rangeTo(it+2).toList()
    }

    println("flatMappedList -> $flatMappedList")
}