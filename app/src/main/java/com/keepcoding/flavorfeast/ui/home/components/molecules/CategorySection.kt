package com.keepcoding.flavorfeast.ui.home.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.flavorfeast.model.CategoryUI
import com.keepcoding.flavorfeast.model.enums.GalleryTypes
import com.keepcoding.flavorfeast.ui.components.FoodCard
import com.keepcoding.flavorfeast.ui.components.LoadingRowScroll
import com.keepcoding.flavorfeast.ui.components.SectionTitle
import com.keepcoding.flavorfeast.ui.navigation.Navigation
import com.keepcoding.flavorfeast.ui.navigation.NavigationController

@Composable
fun CategorySection(isLoading: Boolean, categories: List<CategoryUI>) {
    
    val navController = NavigationController.controller()
    
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SectionTitle(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = "Recipes by category"
        )

        LoadingRowScroll(isLoading = isLoading) {
            items(categories) {
                FoodCard(
                    painter = rememberAsyncImagePainter(it.image),
                    text = it.name,
                    onClick = {
                        navController.navigate(Navigation.GALLERY.createRouteWithArgs(GalleryTypes.CATEGORY, it.name))
                    },
                )
            }
        }     
    }
}