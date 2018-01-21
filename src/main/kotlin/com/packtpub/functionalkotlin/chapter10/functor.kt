package com.packtpub.functionalkotlin.chapter10


sealed class Maybe<out T> {
    object NothingM :Maybe<Nothing>() {
        override fun toString() = "Nothing_"
    }

    data class Just<out T>(val value:T): Maybe<T>()
}


fun <T, R> Maybe<T>.fmap(transform: (T) -> R): Maybe<R> = when(this){
    Maybe.NothingM -> Maybe.NothingM
    is Maybe.Just -> Maybe.Just(transform(value))
}

fun main(args: Array<String>) {
    Maybe.Just(2).fmap{ it + 3}
}