package com.keepcoding.flavorfeast.ui.home.components.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
fun Sections_HomeScreen(viewModel: HomeViewModel) {
    val context = LocalContext.current

    val randomState: ViewState by viewModel.randomState.collectAsState()
    val categoriesState: ViewState by viewModel.categoriesState.collectAsState()
    val areasState: ViewState by viewModel.areasState.collectAsState()
    val ingredientsState: ViewState by viewModel.ingredientsState.collectAsState()
    val randomMeal: MealUI? by viewModel.randomMeal.collectAsState()
    val categories: List<CategoryUI> by viewModel.categories.collectAsState()
    val areas: List<SingleAreaUI> by viewModel.areas.collectAsState()
    val ingredients: List<IngredientsUI> by viewModel.ingredients.collectAsState()

    var alreadyCalledIngredients by rememberSaveable {
        mutableStateOf(false)
    }

    controlErrors(context, randomState, categoriesState, areasState, ingredientsState)

    Column(
        verticalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        RandomSection(
            modifier = Modifier.padding(horizontal = 16.dp),
            meal = randomMeal,
            isLoading = randomState is LoadingState,
            onClick = {
                viewModel.getRandomMeal()
            }
        )

        IngredientsSection(
            ingredients = ingredients,
            onFocus = {
                if (it.isFocused && !alreadyCalledIngredients) {
                    viewModel.getAllIngredients()

                    alreadyCalledIngredients = true
                }
            }
        )

        AreaSection(
            areas = areas,
            isLoading = areasState is LoadingState
        )

        CategorySection(
            categories = categories,
            isLoading = categoriesState is LoadingState
        )
    }
}