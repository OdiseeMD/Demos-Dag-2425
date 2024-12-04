fun main() {
    /*
    - maak een nullable variabele student aan
    - geef die ofwel een null ofwel jouw naam

    - geef het aantal letters weer
    */

    var student : String? = "Steven"
    printLengte(geefLengte(student))
    printLengteString(geefLengte(student), student)

    student = null
    printLengte(geefLengte(student))
    printLengteString(geefLengte(student), student)

}

fun geefLengte(naam: String?) :Int {
    return naam?.length ?: 0
}

fun printLengte(aantal: Int) : Unit {
    println("De lengte van de string is $aantal")
}

fun printLengteString(aantal: Int, naam: String?) : Unit {
    println("De lengte van ${naam ?: "''"} is $aantal")
}