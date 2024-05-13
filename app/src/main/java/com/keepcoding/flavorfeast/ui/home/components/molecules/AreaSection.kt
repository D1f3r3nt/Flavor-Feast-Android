package com.keepcoding.flavorfeast.ui.home.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.model.SingleAreaUI
import com.keepcoding.flavorfeast.model.enums.GalleryTypes
import com.keepcoding.flavorfeast.ui.components.FoodCard
import com.keepcoding.flavorfeast.ui.components.LoadingRowScroll
import com.keepcoding.flavorfeast.ui.components.SectionTitle
import com.keepcoding.flavorfeast.ui.navigation.Navigation
import com.keepcoding.flavorfeast.ui.navigation.NavigationController
import com.keepcoding.flavorfeast.utils.getIDFlagFromArea

@Composable
fun AreaSection(isLoading: Boolean, areas: List<SingleAreaUI>) {

    val navController = NavigationController.controller()
    
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SectionTitle(text = "Areas")

        LoadingRowScroll(isLoading = isLoading) {
            items(areas) {
                FoodCard(
                    painter = painterResource(getIDFlagFromArea(it.area)),
                    text = it.area,
                    onClick = {
                        navController.navigate(Navigation.GALLERY.createRouteWithArgs(GalleryTypes.AREA, it.area))
                    },
                )
            }
        }
    }
}