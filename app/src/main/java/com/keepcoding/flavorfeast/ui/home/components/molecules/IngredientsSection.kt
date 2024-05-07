package com.keepcoding.flavorfeast.ui.home.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.ui.components.SectionTitle
import com.keepcoding.flavorfeast.ui.home.components.atoms.SearchIngredient

@Composable
fun IngredientsSection() {

    val elements = listOf("Patata", "Pelotas")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SectionTitle(text = "Ingredients")

        SearchIngredient(value = "", onValueChange = {})

        ShowFind(elements = elements)
    }
}