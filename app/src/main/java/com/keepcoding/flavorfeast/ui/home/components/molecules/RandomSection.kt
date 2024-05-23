package com.keepcoding.flavorfeast.ui.home.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.ui.home.components.atoms.RandomMeal
import com.keepcoding.flavorfeast.ui.navigation.Navigation
import com.keepcoding.flavorfeast.ui.navigation.NavigationController

@Composable
fun RandomSection(
    modifier: Modifier = Modifier,
    meal: MealUI?, 
    isLoading: Boolean, 
    onClick: () -> Unit
) {
    val navController = NavigationController.controller()

    Column(
        modifier = modifier
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.green)),
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp),
                    color = colorResource(R.color.black)
                )
            } else {
                Text(
                    text = "Surprise Me",
                    fontSize = 16.sp,
                    color = colorResource(R.color.black),
                    fontWeight = FontWeight.Bold,
                )
            }
        }

        if (meal != null) {
            Spacer(modifier = Modifier.height(12.dp))
            
            RandomMeal(
                onClick = {
                    navController.navigate(Navigation.DETAIL.createRouteWithArgs(meal.id))
                },
                meal = meal
            )
        }
    }
}