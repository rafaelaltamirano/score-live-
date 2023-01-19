package com.example.scorelivepoc.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.example.scorelivepoc.R

data class Percentage(
    val value: Int
) {

    @ColorRes
    var color: Int = 0
    lateinit var statusText: String

    @DrawableRes
    var drawableProgress: Int = 0

    init {
        if (value in 0..30) {
            color = R.color.badProgressColor
            statusText = "¡Estás perdiendo dinero!"
            drawableProgress = R.drawable.circle_bad_progress
        }
        if (value in 31..69) {
            color = R.color.middleProgressColor
            statusText = "¡Puedes mejorar!"
            drawableProgress = R.drawable.circle_middle_progress
        }
        if (value in 70..100) {
            color = R.color.colorPrimary
            statusText = "¡Bien hecho!"
            drawableProgress = R.drawable.circle_good_progress
        }
    }
}
