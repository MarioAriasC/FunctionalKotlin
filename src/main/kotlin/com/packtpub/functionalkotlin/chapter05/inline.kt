package com.packtpub.functionalkotlin.chapter05

/**
 * Created by IntelliJ IDEA.
 * @author Mario Arias
 * Date: 1/12/17
 * Time: 3:11 AM
 */


fun <T> time(body: () -> T): Pair<T, Long> {
	val startTime = System.nanoTime()
	val v = body()
	val endTime = System.nanoTime()
	return v to endTime - startTime
}

inline fun <T> inTime(body: () -> T): Pair<T, Long> {
	val startTime = System.nanoTime()
	val v = body()
	val endTime = System.nanoTime()
	return v to endTime - startTime
}

fun main(args: Array<String>) {
	val (_,time) = time { Thread.sleep(1000) }
	val (_,inTime) =inTime { Thread.sleep(1000) }

	println("time = $time")
	println("inTime = $inTime")
}