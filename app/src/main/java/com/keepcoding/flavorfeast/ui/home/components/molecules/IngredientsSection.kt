package com.keepcoding.flavorfeast.ui.home.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.model.IngredientsUI
import com.keepcoding.flavorfeast.ui.components.CustomTitle
import com.keepcoding.flavorfeast.ui.home.components.atoms.SearchComponent

@Composable
fun IngredientsSection(
    ingredients: List<IngredientsUI>,
    onFocus: (FocusState) -> Unit
) {
    var filter by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        CustomTitle(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Ingredients to use up"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SearchComponent(
                value = filter,
                onValueChange = {
                    filter = it
                },
                onFocus = onFocus,
            )

            ShowFind(
                elements = if (filter.isBlank()) {
                    emptyList()
                } else {
                    ingredients.filter {
                        it.name.lowercase().contains(filter.lowercase())
                    }
                }
            )
        }
    }
}