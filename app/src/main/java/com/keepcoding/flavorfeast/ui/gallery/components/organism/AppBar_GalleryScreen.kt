package com.keepcoding.flavorfeast.ui.gallery.components.organism

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.ui.navigation.NavigationController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar_GalleryScreen(
    modifier: Modifier = Modifier,
    name: String?
) {
    val navController = NavigationController.controller()
    
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            name?.let {
                Text(
                    "Filtered by $it",
                    color = colorResource(R.color.white_green)
                )
            } ?: Text(
                "Error",
                color = colorResource(R.color.white_green)
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorResource(R.color.black_green)),
        navigationIcon = {
            IconButton(
                onClick = { 
                    navController.popBackStack()
                }
            ) {
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