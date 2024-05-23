package com.keepcoding.flavorfeast.ui.details.components.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.ui.details.DetailViewModel
import com.keepcoding.flavorfeast.ui.details.components.molecules.InfoSection
import com.keepcoding.flavorfeast.ui.details.components.molecules.HeaderSection
import com.keepcoding.flavorfeast.ui.details.components.molecules.IngredientsSection
import com.keepcoding.flavorfeast.ui.details.components.molecules.InstructionsSection

@Composable
fun Body_DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel,
) {

    val meal: MealUI? by viewModel.meal.collectAsState()

    meal?.let {
        LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                HeaderSection(image = it.image)
            }

            item {
                InfoSection(meal = it)
            }
            
            item {
                InstructionsSection(meal = it)
            }

            item {
                IngredientsSection(meal = it)
            }
        }
    }
}