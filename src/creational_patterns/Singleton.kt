package creational_patterns

import java.util.concurrent.atomic.AtomicInteger

object MySingleton{}

object CounterSingleton {
    private val counter = AtomicInteger(0)

    init {
        println("I was accessed for the first time")
    }

    fun increment() = counter.incrementAndGet()
}

fun main(args: Array<String>) {
    for (i in 1..10) {
        println(CounterSingleton.increment())
    }
}