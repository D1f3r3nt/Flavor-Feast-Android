package com.keepcoding.flavorfeast.ui.gallery.components.organism

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.ui.navigation.NavigationController
import com.keepcoding.flavorfeast.utils.firstUpperCase

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
                    it.firstUpperCase(),
                    color = colorResource(R.color.black),
                    fontWeight = FontWeight.Bold
                )
            } ?: Text(
                "Error",
                color = colorResource(R.color.black)
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorResource(R.color.white)),
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = colorResource(R.color.black),
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    )
}