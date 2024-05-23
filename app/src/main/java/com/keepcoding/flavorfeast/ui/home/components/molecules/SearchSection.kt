package com.keepcoding.flavorfeast.ui.home.components.molecules

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.keepcoding.flavorfeast.ui.home.components.atoms.SearchComponent

@Composable
fun SearchSection(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    SearchComponent(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        placeholder = "Search recipes",
    )
}