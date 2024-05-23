package com.keepcoding.flavorfeast.ui.home.components.organism

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.ui.home.components.atoms.SearchRow
import com.keepcoding.flavorfeast.ui.home.components.atoms.SearchTitle
import com.keepcoding.flavorfeast.ui.navigation.Navigation
import com.keepcoding.flavorfeast.ui.navigation.NavigationController

@Composable
fun Search_HomeScreen(meals: List<MealUI>) {
    val navController = NavigationController.controller()
    
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        SearchTitle(text = "Recipes")

        meals.map {
            SearchRow(
                text = it.name,
                onClick = {
                    navController.navigate(Navigation.DETAIL.createRouteWithArgs(it.id))
                }
            )
        }
    }
}