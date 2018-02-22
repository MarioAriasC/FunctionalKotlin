package com.packtpub.functionalkotlin.chapter10

//List
fun <T, R> List<T>.ap(fab: List<(T) -> R>): List<R> = fab.flatMap { f -> this.map(f) }