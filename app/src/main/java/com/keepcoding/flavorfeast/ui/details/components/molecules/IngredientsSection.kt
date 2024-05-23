package com.keepcoding.flavorfeast.ui.details.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.ui.components.CustomTitle
import com.keepcoding.flavorfeast.ui.details.components.atoms.IngredientRow

@Composable
fun IngredientsSection(
    modifier: Modifier = Modifier,
    meal: MealUI,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CustomTitle(text = "Ingredients")
        
        meal.elements.filter { 
            it.ingredient.isNotBlank()
        }.map { 
            IngredientRow(component = it)
        }
    }
}