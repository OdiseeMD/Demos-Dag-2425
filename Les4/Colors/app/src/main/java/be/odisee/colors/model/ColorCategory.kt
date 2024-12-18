package be.odisee.example.model

import androidx.compose.ui.graphics.Color

enum class ColorCategory {
    RED,
    PINK,
    ORANGE,
    YELLOW,
    PURPLE,
    GREEN,
    BLUE,
    BROWN,
    WHITE,
    GRAY,
    BLACK
}

val ColorCategory.Color: Color
    get() {
        return Color(
            when (this) {
                ColorCategory.RED -> 0xFFFF0000
                ColorCategory.PINK -> 0xFFFFC0CB
                ColorCategory.ORANGE -> 0xFFFFA500
                ColorCategory.YELLOW -> 0xFFFFFF00
                ColorCategory.PURPLE -> 0xFF800080
                ColorCategory.GREEN -> 0xFF008000
                ColorCategory.BLUE -> 0xFF0000FF
                ColorCategory.BROWN -> 0xFFA52A2A
                ColorCategory.WHITE -> 0xFFFFFFFF
                ColorCategory.GRAY -> 0xFF808080
                ColorCategory.BLACK -> 0xFF000000
            }
        )
    }

fun ColorCategory.getTextColor(lightColor: Color, darkColor: Color): Color {

    return when (this) {
        ColorCategory.RED -> darkColor
        ColorCategory.PINK -> lightColor
        ColorCategory.ORANGE -> lightColor
        ColorCategory.YELLOW -> lightColor
        ColorCategory.PURPLE -> darkColor
        ColorCategory.GREEN -> darkColor
        ColorCategory.BLUE -> darkColor
        ColorCategory.BROWN -> darkColor
        ColorCategory.WHITE -> lightColor
        ColorCategory.GRAY -> lightColor
        ColorCategory.BLACK -> darkColor
    }

}