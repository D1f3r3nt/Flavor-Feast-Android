package com.keepcoding.flavorfeast.data.network.response

import com.keepcoding.flavorfeast.model.SingleAreaRemote

data class GetAllAreas (
    val meals: List<SingleAreaRemote>
)