package com.keepcoding.flavorfeast.ui.home.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.CategoryUI
import com.keepcoding.flavorfeast.model.SingleAreaUI
import com.keepcoding.flavorfeast.ui.components.FoodCard
import com.keepcoding.flavorfeast.ui.components.SectionTitle
import com.keepcoding.flavorfeast.utils.getIDFlagFromArea

@Composable
fun AreaSection(isLoading: Boolean, areas: List<SingleAreaUI>) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SectionTitle(text = "Areas")

        if (isLoading) {
            Box(
                modifier =Modifier
                    .height(100.dp),
                contentAlignment = Alignment.Center
            ) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = colorResource(R.color.black_green)
                )
            }
        } else {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(areas) {
                    FoodCard(
                        painter = painterResource(getIDFlagFromArea(it.area)),
                        text = it.area,
                        onClick = {
                            // TODO: Navigate to list
                        },
                    )
                }
            }
        }
    }
}