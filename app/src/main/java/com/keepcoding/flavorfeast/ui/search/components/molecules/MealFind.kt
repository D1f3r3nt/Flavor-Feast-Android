package com.keepcoding.flavorfeast.ui.search.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.MealUI

@Composable
fun MealFind(
    modifier: Modifier = Modifier,
    isZebra: Boolean,
    meal: MealUI,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = if (isZebra) { colorResource(R.color.light_green) } else { colorResource(R.color.white_green) })
            .padding(12.dp)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = meal.name,
            fontSize = 17.sp,
            modifier = Modifier
                .weight(1F)
        )
        Icon(
            imageVector = Icons.Default.ArrowForwardIos,
            contentDescription = null
        )
    }
}