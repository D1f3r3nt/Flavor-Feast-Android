package com.keepcoding.flavorfeast.ui.home.components.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.MealUI

@Composable
fun RandomMeal(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    meal: MealUI,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(12.dp),
                spotColor = colorResource(R.color.grey)
            )
            .clip(RoundedCornerShape(12.dp))
            .background(color = colorResource(R.color.white))
            .clickable(onClick = onClick)
            .padding(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = meal.name,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = meal.category,
                    fontSize = 14.sp,
                    color = colorResource(R.color.grey)
                )
            }

            Image(
                painter = rememberAsyncImagePainter(meal.image),
                contentDescription = null,
                modifier = Modifier
                    .width(103.dp)
                    .height(58.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,

                )
        }
    }
}