package com.keepcoding.flavorfeast.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun FlavorFeastTheme(
    content: @Composable () -> Unit,
) {

    MaterialTheme(
        typography = FlavorFeastTypographic,
        content = content
    )
}