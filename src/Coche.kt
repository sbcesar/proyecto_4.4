/**
 * Clase que representa un coche con sus atributos básicos como color, marca, modelo, número de caballos,
 * número de puertas y matrícula.
 *
 * @property color El color del coche.
 * @property marca La marca del coche.
 * @property modelo El modelo del coche.
 * @property nCaballos El número de caballos del coche.
 * @property nPuertas El número de puertas del coche.
 * @property matricula La matrícula del coche.
 */
class Coche(color: String, marca: String, modelo: String, nCaballos: Int, nPuertas: Int, matricula: String) {

    private var color: String = ""
    private var marca: String = ""
    private var modelo: String = ""
    private var nCaballos: Int = 0
    private var nPuertas: Int = 0
    private var matricula: String = ""

    /**
     * Constructor primario que inicializa los atributos del coche.
     *
     * @param color El color del coche.
     * @param marca La marca del coche.
     * @param modelo El modelo del coche.
     * @param nCaballos El número de caballos del coche.
     * @param nPuertas El número de puertas del coche.
     * @param matricula La matrícula del coche.
     */
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

    /**
     * Valida la matrícula del coche para asegurarse de que tenga el formato correcto.
     *
     * @param matricula La matrícula que se va a validar.
     * @return `true` si la matrícula tiene el formato correcto, `false` de lo contrario.
     */
    private fun validarMatricula(matricula: String): Boolean {
        val primerosCuatro = matricula.substring(0,4)
        val ultimosTres = matricula.substring(4)

        //La matricula debe tener 7 caracteres
        if (matricula.length != 7) {
            return false
        }

        //Los primeros 4 deben ser dígitos y los tres ultimos letras mayusculas
        return primerosCuatro.all { it.isDigit() } && ultimosTres.all { it.isUpperCase() }
    }

    /**
     * Devuelve una representación de cadena del coche incluyendo su color, marca, modelo, caballos, puertas y matricula.
     *
     * @return Representación de cadena del coche.
     */
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