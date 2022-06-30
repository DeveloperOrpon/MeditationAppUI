package com.example.meditationapp

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val title: String,
    @DrawableRes val Icon : Int,
    val lightColor: Color,
    val mediamColor: Color,
    val darkColor: Color
)
