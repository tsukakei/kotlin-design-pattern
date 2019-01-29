package creationalPatterns.factory

interface Building<in UnitType, out ProducedUnit> where UnitType : Enum<*>, ProducedUnit : Unit {
    fun build(type: UnitType) : ProducedUnit
}

interface HQ {
    val buildings: List<Building<*, Unit>>
    fun buildBarracks(): Building<InfantryUnits, Infantry>
    fun buildVehicleFactory(): Building<VehicleUnits, Vehicle>
}

class DogHQ : HQ {
    override val buildings = mutableListOf<Building<*, Unit>>()

    override fun buildBarracks(): Building<InfantryUnits, Infantry> {
        val b = object : Building<InfantryUnits, Infantry> {
            override fun build(type: InfantryUnits): Infantry = when (type) {
                InfantryUnits.RIFLEMAN -> Rifleman()
                InfantryUnits.ROCKET_SOLDIER -> RocketSoldier()
            }
        }
        buildings.add(b)
        return b
    }

    override fun buildVehicleFactory(): Building<VehicleUnits, Vehicle> {
        val vf = object : Building<VehicleUnits, Vehicle> {
            override fun build(type: VehicleUnits): Vehicle = when (type) {
                VehicleUnits.APC -> APC()
                VehicleUnits.TANK -> Tank()
            }
        }
        buildings.add(vf)
        return vf
    }
}

interface Unit

interface Infantry : Unit
class Rifleman : Infantry
class RocketSoldier : Infantry

enum class InfantryUnits {
    RIFLEMAN,
    ROCKET_SOLDIER
}

interface Vehicle : Unit
class APC : Vehicle
class Tank : Vehicle
enum class VehicleUnits {
    APC,
    TANK
}

fun main(args: Array<String>) {
    val hq = DogHQ()
    val barracks1 = hq.buildBarracks()
    val barracks2 = hq.buildBarracks()
    val vehicleFactory1 = hq.buildVehicleFactory()

    val units = listOf(
        barracks1.build(InfantryUnits.RIFLEMAN),
        barracks2.build(InfantryUnits.ROCKET_SOLDIER),
        barracks2.build(InfantryUnits.ROCKET_SOLDIER),
        vehicleFactory1.build(VehicleUnits.TANK),
        vehicleFactory1.build(VehicleUnits.APC),
        vehicleFactory1.build(VehicleUnits.APC)
    )

    for (u in units) {
        println(u)
    }
}