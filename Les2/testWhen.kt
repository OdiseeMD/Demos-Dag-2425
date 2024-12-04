fun main() {
    // schrijf een test om weer te geven hoe goed een student heeft gescoord
    // op basis van een specifiek resultaat :
    // 20 : perfect!
    // >=14 : goed gewerkt
    // >=10 : geslaagd
    // minder dan 10 : niet geslaagd
    // Wat met andere waarden?

    val score = 12

    val resultaat: String = when (score) {
        20 -> "perfect!"
        in 14..19 -> "Goed gewerkt"
        in 10 .. 13 -> "Geslaagd"
        in 0 ..9 -> "Niet geslaagd"
        else -> "Geen correct resultaat (NA)"
    }

    println("Resultaat test : $resultaat")
    println("Resultaat test : ${geefResultaat(score)}")
}

fun geefResultaat(score:Int) : String {
    val resultaat: String = when (score) {
        20 -> "perfect!"
        in 14..19 -> "Goed gewerkt"
        in 10 .. 13 -> "Geslaagd"
        in 0 ..9 -> "Niet geslaagd"
        else -> "Geen correct resultaat (NA)"
    }
    return resultaat
}