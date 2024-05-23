package com.keepcoding.flavorfeast.ui.details.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.ui.components.CustomTitle
import com.keepcoding.flavorfeast.utils.formatWithSortCuts

@Composable
fun InstructionsSection(
    modifier: Modifier = Modifier,
    meal: MealUI,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        CustomTitle(text = "Instructions")
        
        Text(
            text = meal.instructions.formatWithSortCuts(),
            fontSize = 16.sp,
            lineHeight = 24.sp
        )
    }
}