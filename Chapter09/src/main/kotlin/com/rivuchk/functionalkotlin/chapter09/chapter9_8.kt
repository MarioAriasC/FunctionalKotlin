package com.rivuchk.functionalkotlin.chapter09

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {

    val observale = Observable.interval(100, TimeUnit.MILLISECONDS)//1
    val observer = object : Observer<Long> {

        lateinit var disposable: Disposable//2

        override fun onSubscribe(d: Disposable) {
            disposable = d//3
        }

        override fun onNext(item: Long) {
            println("Received $item")
            if (item >= 10 && !disposable.isDisposed) {//4
                disposable.dispose()//5
                println("Disposed")
            }
        }

        override fun onError(e: Throwable) {
            println("Error ${e.message}")
        }

        override fun onComplete() {
            println("Complete")
        }

    }
    runBlocking {
        observale.subscribe(observer)
        delay(1500)//6
    }
}
