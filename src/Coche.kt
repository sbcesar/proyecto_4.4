class Coche(color: String, marca: String, modelo: String, nCaballos: Int, nPuertas: Int, matricula: String) {

    private var color: String = ""
    private var marca: String = ""
    private var modelo: String = ""
    private var nCaballos: Int = 0
    private var nPuertas: Int = 0
    private var matricula: String = ""

    init {
        this.color = color
        this.marca = marca
        this.modelo = modelo
        this.matricula = matricula
    }
    fun getColor(): String { return color }
    //Si la variable es una propiedad de la clase y tratas de validarla puedes usar require
    //Si la variable es local y no una propiedad de la clase entonces se hace la validacion directamente sin usar require:
    //  --->    if (color.isBlank()) { throw IllegalArgumentException("Debes introducir un color no en blanco") }
    fun setColor(nuevoColor: String) {
        try {
            require(nuevoColor.isNotBlank()) {"Debes introducir un color, no dejarlo en blanco."}
            color = nuevoColor
        } catch (e: Exception) {
            println(e.message)
        }

    }

    fun getMarca(): String { return marca }
    fun setMarca(nuevaMarca: String) {
        try {
            require(nuevaMarca.isNotBlank()) { "Debes introducir una marca, no dejarlo en blanco." }
            marca = nuevaMarca
        } catch (e: Exception) {
            println(e.message)
        }

    }

    fun getModelo(): String { return modelo }
    fun setModelo(nuevoModelo: String) {
        try {
            require(nuevoModelo.isNotBlank()) { "Debes introducir un modelo, no dejarlo en blanco." }
            modelo = nuevoModelo
        } catch (e: Exception) {
            println(e.message)
        }
    }

    fun getNumCaballos(): Int { return nCaballos }
    fun setNumCaballos(nuevoNumCaballos: Int) {
        try {
            require(nuevoNumCaballos in 70..700) { "El numero de caballos debe rondar entre 70 y 700 caballos." }
            nCaballos = nuevoNumCaballos
        } catch (e:Exception) {
            println(e.message)
        }
    }

    fun getNumPuertas(): Int { return nPuertas }
    fun setNumPuertas(nuevoNumPuertas: Int) {
        try {
            require(nuevoNumPuertas in 3..5) { "El numero de puertas debe rondar entre 3 y 5 puertas." }
            nPuertas = nuevoNumPuertas
        } catch (e: Exception) {
            println(e.message)
        }
    }

    fun getMatricula(): String { return matricula }
    fun setMatricula(nuevaMatricula: String) {
        try {
            require(validarMatricula(nuevaMatricula)) { "La matricula debe comenzar con 4 dígitos y terminar con 3 números" }
        } catch (e: Exception) {
            println(e.message)
        }
    }

    fun validarMatricula(matricula: String): Boolean {
        val primerosCuatro = matricula.substring(0,4)
        val ultimosTres = matricula.substring(4)

        if (matricula.length != 7) {
            return false
        }

        return primerosCuatro.all { it.isDigit() } && ultimosTres.all { it.isUpperCase() }
    }

    override fun toString(): String {
        return """
        |   Color:      $color
        |   Marca:      $marca
        |   Modelo:     $modelo
        |   Caballos:   $nCaballos
        |   Puertas:    $nPuertas
        |   Matrícula:  $matricula
    """.trimMargin()
    }

}