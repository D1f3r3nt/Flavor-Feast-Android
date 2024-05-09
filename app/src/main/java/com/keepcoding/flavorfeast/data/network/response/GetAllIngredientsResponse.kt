package com.keepcoding.flavorfeast.data.network.response

import com.keepcoding.flavorfeast.model.IngredientsRemote

data class GetAllIngredientsResponse(
    val meals: List<IngredientsRemote>
)