package structualPatterns

typealias PointsOfDamage = Long
typealias Meters = Int

const val GRENADE_DAMAGE : PointsOfDamage = 5L
const val RIFLE_DAMAGE : PointsOfDamage = 3L
const val REGULAR_SPEED : Meters = 1

interface Infantry {
    fun move(x: Long, y: Long)

    fun attack(x: Long, y: Long)
}

interface Weapon {
    fun causeDamage(): PointsOfDamage
}

interface Legs {
    fun move(): Meters
}

class Soldier(private val weapon: Weapon, private val legs: Legs) : Infantry {
    override fun attack(x: Long, y: Long) {
        weapon.causeDamage()
    }

    override fun move(x: Long, y: Long) {
        legs.move()
    }
}

class Grenade : Weapon {
    override fun causeDamage(): PointsOfDamage = GRENADE_DAMAGE
}

class GrenadePack : Weapon {
    override fun causeDamage(): PointsOfDamage = GRENADE_DAMAGE * 3
}

class Rifle : Weapon {
    override fun causeDamage(): PointsOfDamage = RIFLE_DAMAGE
}

class MachineGun : Weapon {
    override fun causeDamage(): PointsOfDamage = RIFLE_DAMAGE * 2
}

class RegularLegs : Legs {
    override fun move(): Meters = REGULAR_SPEED
}

class AthleticLegs : Legs {
    override fun move(): Meters = REGULAR_SPEED * 2
}

fun main(args: Array<String>) {
    val rifleman = Soldier(Rifle(), RegularLegs())
    val grenadier = Soldier(Grenade(), RegularLegs())
    val upgradedRifleman = Soldier(MachineGun(), RegularLegs())
    val upgradedGrenadier = Soldier(GrenadePack(), RegularLegs())
    val lightRifleman = Soldier(Rifle(), AthleticLegs())
    val lightGrenadier = Soldier(Grenade(), AthleticLegs())
}