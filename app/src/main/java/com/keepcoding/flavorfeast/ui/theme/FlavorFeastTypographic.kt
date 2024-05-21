package com.keepcoding.flavorfeast.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.keepcoding.flavorfeast.R

val EpilogueFontFamily = FontFamily(
    Font(R.font.epilogue_regular, FontWeight.Normal),
    Font(R.font.epilogue_bold, FontWeight.Bold),
    Font(R.font.epilogue_black, FontWeight.Black),
    Font(R.font.epilogue_thin, FontWeight.Thin),
)

val FlavorFeastTypographic = Typography(
    bodyLarge = TextStyle(
        fontFamily = EpilogueFontFamily,
        fontWeight = FontWeight.Normal,
    )
)