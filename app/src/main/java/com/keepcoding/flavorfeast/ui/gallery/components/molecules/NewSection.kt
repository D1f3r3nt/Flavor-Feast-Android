package com.keepcoding.flavorfeast.ui.gallery.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.model.SingleMealUI
import com.keepcoding.flavorfeast.ui.components.SectionTitle
import com.keepcoding.flavorfeast.ui.gallery.components.atoms.GalleryRecipe
import com.keepcoding.flavorfeast.ui.navigation.Navigation
import com.keepcoding.flavorfeast.ui.navigation.NavigationController

@Composable
fun NewSection(
    modifier: Modifier = Modifier,
    meals: List<SingleMealUI>,
) {
    val navController = NavigationController.controller()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        SectionTitle(
            text = "New & Trending",
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(meals) {
                GalleryRecipe(
                    meal = it,
                    onClick = {
                        navController.navigate(Navigation.DETAIL.createRouteWithArgs(it.id))
                    },
                )
            }
        }
    }
}