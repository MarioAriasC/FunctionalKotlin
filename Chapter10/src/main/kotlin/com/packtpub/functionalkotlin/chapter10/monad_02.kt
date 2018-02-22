package com.packtpub.functionalkotlin.chapter10

fun calculateDiscount(price: Option<Double>): Option<Double> {
    return price.flatMap { p ->
        if (p > 50.0) {
            Option.Some(5.0)
        } else {
            Option.None
        }
    }
}

fun main(args: Array<String>) {
    println(calculateDiscount(Option.Some(80.0))) //Some(value=5.0)
    println(calculateDiscount(Option.Some(30.0))) //None
    println(calculateDiscount(Option.None)) //None
}
