package com.keepcoding.flavorfeast.ui.details.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.ui.components.CustomTitle
import com.keepcoding.flavorfeast.ui.components.Tag
import com.keepcoding.flavorfeast.ui.details.components.atoms.NameLabel
import com.keepcoding.flavorfeast.utils.firstUpperCase

@Composable
fun InfoSection(
    modifier: Modifier = Modifier,
    meal: MealUI,
) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        NameLabel(
            text = meal.name,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        CustomTitle(
            text = meal.category.firstUpperCase(),
            fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        if (meal.tags.isNotEmpty()) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(meal.tags) {
                    Tag(text = it)
                }
            }
        }

        Button(
            onClick = {
                uriHandler.openUri(meal.video)
            },
            modifier = Modifier
                .height(48.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.green)),
        ) {
            Text(
                text = "Watch Video",
                fontSize = 16.sp,
                color = colorResource(R.color.black),
                fontWeight = FontWeight.Bold,
            )
        }
    }
}