package com.example.a30daysapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.a30daysapp.R

val JuliusSansOne = FontFamily(
    Font(R.font.julius_sans_one_regular)
)

val Monserrat = FontFamily(
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_regular)
)

val Oswald = FontFamily(
    Font(R.font.oswald_medium)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Monserrat,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = JuliusSansOne,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Monserrat,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = onSurfaceLight.copy(0.6f)
    ),
    headlineMedium = TextStyle(
        fontFamily = Oswald,
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal
    )
)