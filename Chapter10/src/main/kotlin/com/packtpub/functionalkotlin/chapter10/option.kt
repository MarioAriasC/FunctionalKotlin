package com.packtpub.functionalkotlin.chapter10

sealed class Option<out T> {
    object None : Option<Nothing>() {
        override fun toString() = "None"
    }

    data class Some<out T>(val value: T) : Option<T>()

    companion object
}

//Option
fun <T, R> Option<T>.map(transform: (T) -> R): Option<R> = flatMap { t -> Option.Some(transform(t)) }

/*fun <T, R> Option<T>.map(transform: (T) -> R): Option<R> = when (this) {
    Option.None -> Option.None
    is Option.Some -> Option.Some(transform(value))
}*/

fun <T, R> Option<T>.flatMap(fm: (T) -> Option<R>): Option<R> = when (this) {
    Option.None -> Option.None
    is Option.Some -> fm(value)
}
//fun <T, R> Option<T>.map(transform: (T) -> R): Option<R> = ap(Option.pure(transform))

fun <T> Option.Companion.pure(t: T): Option<T> = Option.Some(t)

fun <T, R> Option<T>.ap(fab: Option<(T) -> R>): Option<R> = fab.flatMap { f -> map(f) }

infix fun <T, R> Option<(T) -> R>.`(*)`(o: Option<T>): Option<R> = flatMap { f: (T) -> R -> o.map(f) }