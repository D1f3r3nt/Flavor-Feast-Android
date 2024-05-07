package com.keepcoding.flavorfeast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.keepcoding.flavorfeast.ui.home.HomeScreen
import com.keepcoding.flavorfeast.ui.navigation.Navigation
import com.keepcoding.flavorfeast.ui.navigation.NavigationController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavigationController.init(navController)

            Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                NavHost(navController, startDestination = Navigation.HOME_ROUTE) {
                    composable(Navigation.HOME_ROUTE) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}