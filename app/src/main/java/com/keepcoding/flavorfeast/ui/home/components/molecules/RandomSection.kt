package com.keepcoding.flavorfeast.ui.home.components.molecules

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.flavorfeast.R
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.ui.components.FoodCard
import com.keepcoding.flavorfeast.ui.navigation.Navigation
import com.keepcoding.flavorfeast.ui.navigation.NavigationController

@Composable
fun RandomSection(meal: MealUI?, isLoading: Boolean, onClick: () -> Unit) {
    val navController = NavigationController.controller()
    
    Box(
        modifier = Modifier
            .background(colorResource(R.color.turquoise))
            .height(200.dp)
            .fillMaxWidth()
            .clickable {
                if (meal != null) {
                    navController.navigate(Navigation.DETAIL.createRouteWithArgs(meal.id))
                }
            },
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = if (meal == null) {
                painterResource(R.drawable.random_food)
            } else {
                rememberAsyncImagePainter(meal.image)
            },
            contentDescription = null,
            contentScale = if (meal == null) {
                ContentScale.Fit
            } else {
                ContentScale.Crop
            }
        )
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = meal?.name ?: "???",
                color = colorResource(R.color.white_green),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.light_green)),
                border = BorderStroke(1.dp, colorResource(R.color.green))
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = colorResource(R.color.grey)
                    )
                } else {
                    Text(
                        text = "Random",
                        color = colorResource(R.color.grey)
                    )
                }
            }
        }
    }
    
    
}