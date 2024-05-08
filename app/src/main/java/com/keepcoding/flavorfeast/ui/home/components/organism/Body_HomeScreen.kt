package com.keepcoding.flavorfeast.ui.home.components.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.model.CategoryUI
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.model.enums.LoadingState
import com.keepcoding.flavorfeast.model.enums.ViewState
import com.keepcoding.flavorfeast.ui.home.HomeViewModel
import com.keepcoding.flavorfeast.ui.home.components.molecules.AreaSection
import com.keepcoding.flavorfeast.ui.home.components.molecules.CategorySection
import com.keepcoding.flavorfeast.ui.home.components.molecules.IngredientsSection
import com.keepcoding.flavorfeast.ui.home.components.molecules.RandomSection

@Composable
fun Body_HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel) {
    val randomMeal: MealUI? by viewModel.randomMeal.collectAsState()
    val randomState: ViewState by viewModel.randomState.collectAsState()
    val categories: List<CategoryUI> by viewModel.categories.collectAsState()
    val categoriesState: ViewState by viewModel.categoriesState.collectAsState()
    
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            RandomSection(
                meal = randomMeal,
                isLoading = randomState is LoadingState,
                onClick = {
                    viewModel.getRandomMeal()
                }
            )
        }

        item {
            IngredientsSection()
        }

        item {
            CategorySection(
                categories = categories,
                isLoading = categoriesState is LoadingState
            )
        }

        item {
            AreaSection()
        }

        item {
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
        }
    }
}