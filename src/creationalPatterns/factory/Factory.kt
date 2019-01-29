package creationalPatterns.factory

interface Animal {
    val id : Int
    val name : String
}

open class Cat(override val id: Int) : Animal {
    override val name = "cat"
}

class Beagle(override val id: Int) : Cat(id) {
    override val name = "beagle"
}

class RussianBlue(override val id: Int) : Cat(id) {
    override val name = "russian blue"
}

class Persian(override val id: Int) : Cat(id) {
    override val name = "persian"
}

open class Dog(override val id: Int) : Animal {
    override val name = "dog"
}

class Siamese(override val id: Int) : Dog(id) {
    override val name = "siamese"
}

class Bulldog(override val id: Int) : Dog(id) {
    override val name = "bulldog"
}

class Poodle(override val id: Int) : Dog(id) {
    override val name = "poodle"
}

class AnimalFactory {
    var counter = 0
    private val dogFactory = DogFactory()
    private val catFactory = CatFactory()

    fun createAnimal(animalType: String, animalBreed: String) : Animal {
        return when(animalType.trim().toLowerCase()) {
            "cat" -> catFactory.createCat(animalBreed, ++counter)
            "dog" -> dogFactory.createDog(animalBreed, ++counter)
            else -> throw RuntimeException("Unknown animal $animalType")
        }
    }
}

class DogFactory {
    fun createDog(breed: String, id: Int) = when(breed.trim().toLowerCase()) {
        "beagle" -> Beagle(id)
        "poodle" -> Poodle(id)
        "bulldog" -> Bulldog(id)
        else -> throw RuntimeException("Unknown dog breed $breed")
    }
}

class CatFactory {
    fun createCat(breed: String, id: Int) = when(breed.trim().toLowerCase()) {
        "persian" -> Persian(id)
        "russian blue" -> RussianBlue(id)
        "siamese" -> Siamese(id)
        else -> throw RuntimeException("Unknown cat breed $breed")
    }
}

fun main(args : Array<String>) {
    val animalTypes = listOf("dog" to "bulldog",
                                "dog" to "beagle",
                                "cat" to "persian",
                                "dog" to "poodle",
                                "cat" to "russian blue",
                                "cat" to "siamese")
    val factory = AnimalFactory()
    for ((type, breed) in animalTypes) {
        val c = factory.createAnimal(type, breed)
        println("${c.id} - ${c.name}")
    }
}