package com.keepcoding.flavorfeast.ui.navigation

sealed class Navigation(val route: String) {
    companion object {
        const val HOME_ROUTE = "home"
    }

    object HOME: Navigation(HOME_ROUTE)
}