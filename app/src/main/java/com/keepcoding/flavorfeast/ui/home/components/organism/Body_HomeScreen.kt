package com.keepcoding.flavorfeast.ui.home.components.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.model.CategoryUI
import com.keepcoding.flavorfeast.model.IngredientsUI
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.model.SingleAreaUI
import com.keepcoding.flavorfeast.model.enums.LoadingState
import com.keepcoding.flavorfeast.model.enums.ViewState
import com.keepcoding.flavorfeast.ui.home.HomeViewModel
import com.keepcoding.flavorfeast.ui.home.components.molecules.AreaSection
import com.keepcoding.flavorfeast.ui.home.components.molecules.CategorySection
import com.keepcoding.flavorfeast.ui.home.components.molecules.IngredientsSection
import com.keepcoding.flavorfeast.ui.home.components.molecules.RandomSection
import com.keepcoding.flavorfeast.utils.controlErrors

@Composable
fun Body_HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel) {
    val context = LocalContext.current

    val randomMeal: MealUI? by viewModel.randomMeal.collectAsState()
    val randomState: ViewState by viewModel.randomState.collectAsState()
    val categories: List<CategoryUI> by viewModel.categories.collectAsState()
    val categoriesState: ViewState by viewModel.categoriesState.collectAsState()
    val areas: List<SingleAreaUI> by viewModel.areas.collectAsState()
    val areasState: ViewState by viewModel.areasState.collectAsState()
    val ingredients: List<IngredientsUI> by viewModel.ingredients.collectAsState()
    val ingredientsState: ViewState by viewModel.ingredientsState.collectAsState()

    var alreadyCalledIngredients by rememberSaveable {
        mutableStateOf(false)
    }

    controlErrors(context, randomState, categoriesState, areasState, ingredientsState)

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
            IngredientsSection(
                ingredients = ingredients,
                onFocus = {
                    if (it.isFocused && !alreadyCalledIngredients) {
                        viewModel.getAllIngredients()

                        alreadyCalledIngredients = true
                    }
                }
            )
        }

        item {
            CategorySection(
                categories = categories,
                isLoading = categoriesState is LoadingState
            )
        }

        item {
            AreaSection(
                areas = areas,
                isLoading = areasState is LoadingState
            )
        }

        item {
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
        }
    }
}