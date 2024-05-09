package com.keepcoding.flavorfeast.data.network.response

import com.keepcoding.flavorfeast.model.SingleAreaRemote

data class GetAllAreasResponse (
    val meals: List<SingleAreaRemote>
)