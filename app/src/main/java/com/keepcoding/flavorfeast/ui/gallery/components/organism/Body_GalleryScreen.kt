package com.keepcoding.flavorfeast.ui.gallery.components.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.flavorfeast.model.SingleMealUI
import com.keepcoding.flavorfeast.ui.components.FoodCard
import com.keepcoding.flavorfeast.ui.gallery.GalleryViewModel
import com.keepcoding.flavorfeast.ui.navigation.Navigation
import com.keepcoding.flavorfeast.ui.navigation.NavigationController

@Composable
fun Body_GalleryScreen(
    modifier: Modifier = Modifier,
    viewModel: GalleryViewModel,
) {
    
    val navController = NavigationController.controller()
    val meals: List<SingleMealUI> by viewModel.meals.collectAsState()
    
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(meals) { meal ->
            FoodCard(
                painter = rememberAsyncImagePainter(meal.image),
                text = meal.name,
                onClick = {
                    navController.navigate(Navigation.DETAIL.createRouteWithArgs(meal.id))
                }
            )
        }
    }
}