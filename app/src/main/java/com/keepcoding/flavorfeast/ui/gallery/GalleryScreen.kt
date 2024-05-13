package com.keepcoding.flavorfeast.ui.gallery

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import com.keepcoding.flavorfeast.ui.gallery.components.organism.AppBar_GalleryScreen
import com.keepcoding.flavorfeast.ui.gallery.components.organism.Body_GalleryScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryScreen(
    args: NavBackStackEntry,
    viewModel: GalleryViewModel = hiltViewModel()
) {
    GalleryGateway.gateway(args, viewModel)

    val galleryName: String? by viewModel.nameType.collectAsState()

    Scaffold(
        topBar = { AppBar_GalleryScreen(name = galleryName) }
    ) {
        Body_GalleryScreen(Modifier.padding(it), viewModel)
    }
}