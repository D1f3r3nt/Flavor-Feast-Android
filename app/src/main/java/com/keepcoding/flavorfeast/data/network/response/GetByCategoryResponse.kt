package com.keepcoding.flavorfeast.data.network.response

import com.keepcoding.flavorfeast.model.SingleMealRemote

data class GetByCategoryResponse (
    val meals: List<SingleMealRemote>
)