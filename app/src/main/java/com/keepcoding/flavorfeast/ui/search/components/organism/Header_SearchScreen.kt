package com.keepcoding.flavorfeast.ui.search.components.organism

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.keepcoding.flavorfeast.ui.navigation.NavigationController
import com.keepcoding.flavorfeast.ui.search.SearchViewModel
import com.keepcoding.flavorfeast.ui.search.components.molecules.SearchField

@Composable
fun Header_SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel,
) {
    val searchText by viewModel.searchText.collectAsState()
    
    val navController = NavigationController.controller()
    
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = null
            )
        }

        SearchField(
            value = searchText,
            onValueChange = viewModel::onSearchTextChange
        )
    }
}