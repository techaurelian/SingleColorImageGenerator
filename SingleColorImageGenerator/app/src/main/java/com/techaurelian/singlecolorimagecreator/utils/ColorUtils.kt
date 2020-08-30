package com.techaurelian.singlecolorimagecreator.utils

import androidx.annotation.ColorInt

object ColorUtils {
    fun fullAlpha(@ColorInt color: Int): Int = 0xFF000000.toInt() or color

    fun colorToHex(@ColorInt color: Int): String = "#%06X".format(color and 0x00ffffff)

}