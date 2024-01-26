fun main() {
    val coche1 = Coche("Rojo","cupra","terramar",0,0,"2442ABC")

    //Pide el numero de caballos
    println("Introduce el numero de caballos del ${coche1.getMarca()}")
    val caballos = readln().toInt()
    coche1.setNumCaballos(caballos)

    //Pide el numero de puertas
    println("Introduce el numero de puertas del ${coche1.getMarca()}")
    val puertas = readln().toInt()
    coche1.setNumPuertas(puertas)

    println(coche1.toString())
}