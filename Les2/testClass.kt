fun main() {
    /*
        Maak class voertuig
            een voertuig heeft 2 functies : start en stop
            een voertuig heeft een variabele : isAanHetRijden
        Maak een klasse fiets
            een fiets heeft een functie : bel
        Maak een klasse wagen
            een wagen heeft een functie : claxoneer

        Maak een object persoon, die een wagen en een fiets heeft
     */

    val steven = Persoon(
        fiets = Fiets(),
        wagen = Wagen()
    )

    steven.wagen.start()
    steven.wagen.claxonneer()
    steven.wagen.stop()
    steven.fiets.start()
    steven.fiets.bel()
    steven.fiets.stop()
}

open class Voertuig(var isAanHetRijden: Boolean = false) {

    fun start() {
        isAanHetRijden = true
        println("Het voertuig is nu aan het rijden")
    }

    fun stop() {
        isAanHetRijden = false
        println("Het voertuig is nu gestopt")
    }
}

class Fiets(isAanHetRijden: Boolean = false) : Voertuig( isAanHetRijden) {

    fun bel() {
        println("Tring, tring!")
    }
}

class Wagen(isAanHetRijden: Boolean = false) : Voertuig( isAanHetRijden) {

    fun claxonneer() {
        println("Tuut, Tuut!")
    }
}

class Persoon(
    val fiets: Fiets,
    val wagen: Wagen
) {

}