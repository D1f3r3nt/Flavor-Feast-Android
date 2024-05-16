package com.keepcoding.flavorfeast.ui.home.components.organism

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.ui.navigation.Navigation
import com.keepcoding.flavorfeast.ui.navigation.NavigationController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar_HomeScreen() {
    val navController = NavigationController.controller()
    
    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorResource(R.color.black_green)),
        actions = {
            IconButton(
                onClick = {
                    navController.navigate(Navigation.SEARCH.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = colorResource(R.color.white_green),
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    )
}