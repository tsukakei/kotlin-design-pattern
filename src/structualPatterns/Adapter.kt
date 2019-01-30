package structualPatterns

interface UsbTypeC
interface UsbMini

interface EUPlug
interface USPlug

fun powerOutlet() : USPlug {
    return object : USPlug {}
}

fun USPlug.toEUPlug() : EUPlug {
    return object : EUPlug {}
}

fun UsbMini.toUsbTypeC() : UsbTypeC {
    return object : UsbTypeC {}
}

fun cellPhone(chargeCable: UsbTypeC) {

}

fun charger(plug: EUPlug) : UsbMini {
    return object : UsbMini {}
}

fun main(args : Array<String>) {
    cellPhone(charger(
        powerOutlet().toEUPlug()
    ).toUsbTypeC())
}