package com.keepcoding.flavorfeast.data.network.response

import com.keepcoding.flavorfeast.model.CategoryRemote

data class GetAllCategories (
    val categories: List<CategoryRemote>
)