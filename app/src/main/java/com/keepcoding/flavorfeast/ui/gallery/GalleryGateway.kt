package com.keepcoding.flavorfeast.ui.gallery

import androidx.navigation.NavBackStackEntry
import com.keepcoding.flavorfeast.model.enums.GalleryTypes
import com.keepcoding.flavorfeast.ui.navigation.Navigation

object GalleryGateway {
    fun gateway(
        args: NavBackStackEntry,
        viewModel: GalleryViewModel
    ) {
        val argName = args.arguments?.getString(Navigation.GALLERY.ARG_NAME)
        val argType =args.arguments?.getString(Navigation.GALLERY.ARG_TYPE)
        
        if (argName != null && argType != null) {
            getEnum(argType)?.let {
                viewModel.setArgs(it, argName)
            }
        }
    }

    private fun getEnum(value: String): GalleryTypes? {
        return when (value) {
            "ingredients" -> GalleryTypes.INGREDIENTS
            "area" -> GalleryTypes.AREA
            "category" -> GalleryTypes.CATEGORY
            else -> null
        }
    }
}
