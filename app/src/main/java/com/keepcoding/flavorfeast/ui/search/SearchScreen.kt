package com.keepcoding.flavorfeast.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.ui.search.components.organism.Body_SearchScreen
import com.keepcoding.flavorfeast.ui.search.components.organism.Header_SearchScreen

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.white_green))
    ) {
        Header_SearchScreen(viewModel = viewModel)

        HorizontalDivider()

        Body_SearchScreen(viewModel = viewModel)
    }
}