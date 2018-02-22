package com.packtpub.appendix

fun main(args: Array<String>) {
    for (i in 1..10) {
        println("i = $i")
    }

    var i = 1

    while (i <= 10) {
        println("i = $i")
        i++
    }

    do {
        i--
        println("i = $i")
    } while (i > 0)
}