package com.keepcoding.flavorfeast.ui.details.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.ui.components.SectionTitle
import com.keepcoding.flavorfeast.ui.components.Tag
import com.keepcoding.flavorfeast.ui.details.components.atoms.IngredientRow

@Composable
fun InfoSide(
    modifier: Modifier = Modifier,
    meal: MealUI,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = meal.name,
            fontSize = 24.sp,
            color = colorResource(R.color.black_green),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )

        if (meal.tags.isNotEmpty()) {
            SectionTitle(text = "Tags", fontSize = 17.sp)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                meal.tags.map {
                    Tag(text = it)
                }
            }
        }

        SectionTitle(text = "Ingredients", fontSize = 17.sp)

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            meal.elements.map {
                if (it.ingredient.isNotBlank()) {
                    IngredientRow(component = it)
                }
            }
        }

        SectionTitle(text = "Instructions", fontSize = 17.sp)

        Text(
            meal.instructions
                .replace("\t", "    ")
                .replace("\r", "\n")
        )
    }
}