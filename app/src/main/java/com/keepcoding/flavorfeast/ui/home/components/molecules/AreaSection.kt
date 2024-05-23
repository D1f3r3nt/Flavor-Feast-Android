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
import com.keepcoding.flavorfeast.ui.components.CustomTitle
import com.keepcoding.flavorfeast.ui.navigation.Navigation
import com.keepcoding.flavorfeast.ui.navigation.NavigationController
import com.keepcoding.flavorfeast.utils.getIDFlagFromArea

@Composable
fun AreaSection(isLoading: Boolean, areas: List<SingleAreaUI>) {

    val navController = NavigationController.controller()
    
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CustomTitle(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = "Recipes by area"
        )

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