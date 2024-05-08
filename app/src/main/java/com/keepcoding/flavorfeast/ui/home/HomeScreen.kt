package com.keepcoding.flavorfeast.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.ui.home.components.organism.AppBar_HomeScreen
import com.keepcoding.flavorfeast.ui.home.components.organism.Body_HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    Scaffold(
        topBar = { AppBar_HomeScreen(actionOnClick = {}) },
        containerColor = colorResource(R.color.white_green)
    ) {
        Body_HomeScreen(modifier = Modifier.padding(it), viewModel = viewModel)
    }
}