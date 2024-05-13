package com.keepcoding.flavorfeast.ui.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.enums.ErrorState
import com.keepcoding.flavorfeast.model.enums.LoadingState
import com.keepcoding.flavorfeast.model.enums.ViewState
import com.keepcoding.flavorfeast.ui.details.components.organism.AppBar_DetailScreen
import com.keepcoding.flavorfeast.ui.details.components.organism.Body_DetailScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    args: NavBackStackEntry,
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val mealState: ViewState by viewModel.mealState.collectAsState()

    DetailGateway.gateway(args, viewModel)

    Scaffold(
        topBar = { AppBar_DetailScreen() }
    ) {
        when (mealState) {
            is LoadingState -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = colorResource(R.color.black_green),
                    )
                }
            }

            is ErrorState -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text((mealState as ErrorState).msg)
                }
            }

            else -> {
                Body_DetailScreen(modifier = Modifier.padding(it), viewModel)
            }
        }
    }
}