package com.keepcoding.flavorfeast

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.keepcoding.flavorfeast.ui.details.DetailScreen
import com.keepcoding.flavorfeast.ui.gallery.GalleryScreen
import com.keepcoding.flavorfeast.ui.home.HomeScreen
import com.keepcoding.flavorfeast.ui.navigation.Navigation
import com.keepcoding.flavorfeast.ui.navigation.NavigationController
import com.keepcoding.flavorfeast.ui.theme.FlavorFeastTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContent {
            val navController = rememberNavController()
            NavigationController.init(navController)

            FlavorFeastTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavHost(navController, startDestination = Navigation.HOME_ROUTE) {
                        composable(Navigation.HOME_ROUTE) {
                            HomeScreen()
                        }

                        composable(
                            Navigation.GALLERY_ROUTE, arguments = listOf(
                                navArgument(Navigation.GALLERY.ARG_TYPE) {
                                    nullable = false
                                    type = NavType.StringType
                                },
                                navArgument(Navigation.GALLERY.ARG_NAME) {
                                    nullable = false
                                    type = NavType.StringType
                                },
                            )
                        ) {
                            GalleryScreen(it)
                        }

                        composable(
                            Navigation.DETAIL_ROUTE, arguments = listOf(
                                navArgument(Navigation.DETAIL.ARG_ID_MEAL) {
                                    nullable = false
                                    type = NavType.StringType
                                },
                            )
                        ) {
                            DetailScreen(it)
                        }
                    }
                }
            }
        }
    }
}