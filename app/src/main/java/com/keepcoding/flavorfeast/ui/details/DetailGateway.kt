package com.keepcoding.flavorfeast.ui.details

import androidx.navigation.NavBackStackEntry
import com.keepcoding.flavorfeast.ui.navigation.Navigation

object DetailGateway {
    fun gateway(
        args: NavBackStackEntry,
        viewModel: DetailViewModel
    ) {
        args.arguments?.getString(Navigation.DETAIL.ARG_ID_MEAL)?.let {
            viewModel.setArgs(it)
        }
    }
}