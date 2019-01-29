package creational_patterns.factory

class NumberMaster {
    companion object {
        fun valueOf(hopefullyNumber: String) : Long = hopefullyNumber.toLong()
    }
}

fun main(args: Array<String>) {
    println(NumberMaster.valueOf("123"))
}