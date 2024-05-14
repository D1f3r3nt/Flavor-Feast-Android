package com.keepcoding.flavorfeast.ui.details.components.organism

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.ui.details.DetailViewModel
import com.keepcoding.flavorfeast.ui.details.components.molecules.InfoSide
import com.keepcoding.flavorfeast.ui.details.components.molecules.VideoSide

@Composable
fun Body_DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel,
) {

    val meal: MealUI? by viewModel.meal.collectAsState()

    meal?.let {
        LazyColumn(
            modifier = modifier
        ) {
            item {
                VideoSide(
                    image = it.image,
                    video = it.video,
                )
            }

            item {
                InfoSide(meal = it)
            }
        }
    }
}