package com.keepcoding.flavorfeast.data.network

import com.keepcoding.flavorfeast.model.CategoryRemote
import com.keepcoding.flavorfeast.model.MealRemote

interface NetworkDataSourceInterface {

    suspend fun getRandomMeal(): Result<MealRemote>
    suspend fun getAllCategories(): Result<List<CategoryRemote>>
}