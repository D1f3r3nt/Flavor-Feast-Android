package com.keepcoding.flavorfeast.ui.home.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.ui.components.FoodCard

@Composable
fun RandomSection(meal: MealUI?, isLoading: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .background(colorResource(R.color.turquoise))
            .padding(vertical = 12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        FoodCard(
            painter = if (meal == null) {
                painterResource(R.drawable.random_food)
            } else {
                rememberAsyncImagePainter(meal.image)
            },
            text = meal?.name ?: "???",
            onClick = {
                // TODO: Navigate to detail
            }
        )

        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.black_green))
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = colorResource(R.color.white_green)
                )
            } else {
                Text(
                    text = "Random",
                    color = colorResource(R.color.white_green)
                )
            }
        }
    }
}