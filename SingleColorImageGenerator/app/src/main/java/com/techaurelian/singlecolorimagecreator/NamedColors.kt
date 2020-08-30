package com.techaurelian.singlecolorimagecreator

import androidx.annotation.ColorInt

class NamedColors {

}

enum class NamedColor(@ColorInt val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}