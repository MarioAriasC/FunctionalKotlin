package com.packtpub.functionalkotlin.chapter10

//Function
fun <A, B, C> ((A) -> B).map(transform: (B) -> C): (A) -> C = { t -> transform(this(t)) }

fun <A, B, C> ((A) -> B).flatMap(fm: (B) -> (A) -> C): (A) -> C = { t -> fm(this(t))(t) }

fun <A, B, C> ((A) -> B).ap(fab: (A) -> (B) -> C): (A) -> C = fab.flatMap { f -> map(f) }


object Function1 {
    fun <A, B> pure(b: B) = { _: A -> b }
}