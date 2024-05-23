package com.keepcoding.flavorfeast.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.R

@Composable
fun FoodCard(
    modifier: Modifier = Modifier,
    painter: Painter,
    text: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .width(160.dp)
                .height(90.dp),
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                // TODO: Fix this
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }

        Text(
            text = text,
            fontSize = 17.sp,
            color = colorResource(R.color.black),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}