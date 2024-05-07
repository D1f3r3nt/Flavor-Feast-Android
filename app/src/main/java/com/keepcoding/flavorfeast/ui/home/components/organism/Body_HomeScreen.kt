package com.keepcoding.flavorfeast.ui.home.components.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keepcoding.flavorfeast.ui.home.components.molecules.AreaSection
import com.keepcoding.flavorfeast.ui.home.components.molecules.CategorySection
import com.keepcoding.flavorfeast.ui.home.components.molecules.IngredientsSection
import com.keepcoding.flavorfeast.ui.home.components.molecules.RandomSection

@Composable
fun Body_HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            RandomSection(
                onClick = {}
            )
        }

        item {
            IngredientsSection()
        }

        item {
            CategorySection()
        }

        item {
            AreaSection()
        }

        item {
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
        }
    }
}