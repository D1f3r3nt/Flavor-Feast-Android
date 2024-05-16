package com.keepcoding.flavorfeast.ui.navigation

import com.keepcoding.flavorfeast.model.enums.GalleryTypes
import com.keepcoding.flavorfeast.ui.navigation.Navigation.DETAIL.ARG_ID_MEAL
import com.keepcoding.flavorfeast.ui.navigation.Navigation.GALLERY.ARG_NAME
import com.keepcoding.flavorfeast.ui.navigation.Navigation.GALLERY.ARG_TYPE

sealed class Navigation(val route: String) {
    companion object {
        const val HOME_ROUTE = "home"
        const val SEARCH_ROUTE = "search"
        const val GALLERY_ROUTE = "gallery/{$ARG_TYPE}/{$ARG_NAME}"
        const val DETAIL_ROUTE = "detail/{$ARG_ID_MEAL}"
    }

    object HOME: Navigation(HOME_ROUTE)
    object SEARCH: Navigation(SEARCH_ROUTE)
    
    object GALLERY: Navigation(GALLERY_ROUTE) {
        const val ARG_TYPE = "type"
        const val ARG_NAME = "name"
        
        fun createRouteWithArgs(type: GalleryTypes, name: String): String {
            return "gallery/${type.value}/$name"
        }
    }
    
    object DETAIL: Navigation(DETAIL_ROUTE) {
        const val ARG_ID_MEAL = "idMeal"
        
        fun createRouteWithArgs(id: String): String {
            return "detail/$id"
        }
    }
}