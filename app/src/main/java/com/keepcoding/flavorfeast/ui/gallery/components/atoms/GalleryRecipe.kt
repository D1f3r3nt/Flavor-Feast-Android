package com.keepcoding.flavorfeast.ui.gallery.components.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.SingleMealUI

@Composable
fun GalleryRecipe(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    meal: SingleMealUI,
    size: Dp = 240.dp
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(14.dp),
        modifier = modifier
            .width(size)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = rememberAsyncImagePainter(meal.image),
            contentDescription = null,
            modifier = Modifier
                .size(size)
                .clip(RoundedCornerShape(12.dp))
        )

        Text(
            text = meal.name,
            fontSize = 16.sp,
            maxLines = 1,
            fontWeight = FontWeight.Medium,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth(),
        )

        Text(
            text = "#${meal.id}",
            fontSize = 14.sp,
            color = colorResource(R.color.grey),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}