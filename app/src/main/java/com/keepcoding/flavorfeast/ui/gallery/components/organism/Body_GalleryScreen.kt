package com.keepcoding.flavorfeast.ui.gallery.components.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.SingleMealUI
import com.keepcoding.flavorfeast.ui.gallery.GalleryViewModel
import com.keepcoding.flavorfeast.ui.gallery.components.molecules.MoreSection
import com.keepcoding.flavorfeast.ui.gallery.components.molecules.NewSection

@Composable
fun Body_GalleryScreen(
    modifier: Modifier = Modifier,
    viewModel: GalleryViewModel,
) {

    val meals: List<SingleMealUI> by viewModel.meals.collectAsState()
    val newMeals: List<SingleMealUI> by viewModel.newMeals.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.white)),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        item {
            NewSection(meals = newMeals)
        }

        item {
            MoreSection(meals = meals)
        }
    }
}