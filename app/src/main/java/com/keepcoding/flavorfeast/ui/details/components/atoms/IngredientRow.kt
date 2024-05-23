package com.keepcoding.flavorfeast.ui.details.components.atoms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.ComponentUI

@Composable
fun IngredientRow(
    modifier: Modifier = Modifier,
    component: ComponentUI,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = component.ingredient,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            text = component.measure,
            fontSize = 14.sp,
            color = colorResource(R.color.grey),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}