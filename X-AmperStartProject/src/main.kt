fun main() {
    toonOffer(20, "Google Chromecast")
    toonOffer(15, "iPhone")
    toonOffer(21, "Monitor - Asus - 15\"")
}

fun toonOffer(discountPercentage: Int, item: String) : Unit {
    // println(offer)
    val extradiscountPercentage = discountPercentage + 10
    println("Sale - Up to $extradiscountPercentage% discount on $item! Hurry up!")
}