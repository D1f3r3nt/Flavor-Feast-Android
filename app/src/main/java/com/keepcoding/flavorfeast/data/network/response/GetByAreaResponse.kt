package com.keepcoding.flavorfeast.data.network.response

import com.keepcoding.flavorfeast.model.SingleMealRemote

data class GetByAreaResponse(
    val meals: List<SingleMealRemote>
)