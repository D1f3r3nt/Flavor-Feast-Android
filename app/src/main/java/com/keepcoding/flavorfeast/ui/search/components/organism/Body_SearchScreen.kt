package com.keepcoding.flavorfeast.ui.search.components.organism

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.keepcoding.flavorfeast.ui.navigation.Navigation
import com.keepcoding.flavorfeast.ui.navigation.NavigationController
import com.keepcoding.flavorfeast.ui.search.SearchViewModel
import com.keepcoding.flavorfeast.ui.search.components.molecules.MealFind

@Composable
fun Body_SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel,
) {
    val meals by viewModel.meals.collectAsState()
    val navController = NavigationController.controller()

    LazyColumn(
        modifier = modifier
    ) {
        itemsIndexed(meals) { index, meal ->
            MealFind(
                isZebra = index % 2 == 0,
                meal = meal,
                onClick = {
                    navController.navigate(Navigation.DETAIL.createRouteWithArgs(meal.id))
                }
            )
        }
    }
}