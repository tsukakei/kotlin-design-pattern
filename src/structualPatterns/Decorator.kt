package structualPatterns

class HappyMap<K, V>(private val map: MutableMap<K, V> = mutableMapOf()): MutableMap<K, V> by map {
    override fun put(key: K, value: V): V? {
        return map.put(key, value).apply {
            this?.let {
                println("Yay! $key")
            }
        }
    }
}

class SadMap<K, V>: HashMap<K, V>() {
    override fun remove(key: K): V? {
        println("Okay...")
        return super.remove(key)
    }
}

fun main(args: Array<String>) {
    val sadHappy = HappyMap(SadMap<String, String>())
    sadHappy["one"] = "one"
    sadHappy["one"] = "two"
    sadHappy.remove("one")
    println(sadHappy is HappyMap)
    println(sadHappy is MutableMap<*, *>)
    println(sadHappy is SadMap<*, *>)
}