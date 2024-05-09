package com.keepcoding.flavorfeast.data.network.response

import com.keepcoding.flavorfeast.model.CategoryRemote

data class GetAllCategoriesResponse (
    val categories: List<CategoryRemote>
)