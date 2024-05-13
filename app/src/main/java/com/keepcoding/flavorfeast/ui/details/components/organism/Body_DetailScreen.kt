package com.keepcoding.flavorfeast.ui.details.components.organism

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.ui.components.Tag
import com.keepcoding.flavorfeast.ui.details.DetailViewModel
import com.keepcoding.flavorfeast.utils.getIDFlagFromArea

@Composable
fun Body_DetailScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel,
) {

    val meal: MealUI? by viewModel.meal.collectAsState()

    meal?.let {
        Column(
            modifier = modifier
        ) {
            Image(
                painter = rememberAsyncImagePainter(it.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = it.name,
                    fontSize = 24.sp,
                    color = colorResource(R.color.black_green),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(getIDFlagFromArea(it.area)),
                        contentDescription = null,
                        modifier = Modifier
                            .width(70.dp)
                    )

                    LazyVerticalGrid(
                        columns = GridCells.FixedSize(50.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        items(it.tags) {
                            Tag(text = it)
                        }
                    }
                }
            }
        }
    }
}