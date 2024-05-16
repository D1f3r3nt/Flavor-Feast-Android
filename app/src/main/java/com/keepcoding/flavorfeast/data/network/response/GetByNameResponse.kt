package com.keepcoding.flavorfeast.data.network.response

import com.keepcoding.flavorfeast.model.MealRemote

data class GetByNameResponse (
    val meals: List<MealRemote>?
)