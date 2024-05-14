package com.keepcoding.flavorfeast.ui.details.components.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.ui.details.DetailViewModel
import com.keepcoding.flavorfeast.ui.navigation.NavigationController
import com.keepcoding.flavorfeast.utils.getIDFlagFromArea

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar_DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel,
) {
    val navController = NavigationController.controller()
    val meal: MealUI? by viewModel.meal.collectAsState()
    
    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorResource(R.color.black_green)),
        actions = {
            meal?.let {
                Image(
                    painter = rememberAsyncImagePainter(getIDFlagFromArea(it.area)),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .border(2.dp, colorResource(R.color.white_green), RoundedCornerShape(20.dp))
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = null,
                    tint = colorResource(R.color.white_green),
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    )
}