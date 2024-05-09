package com.keepcoding.flavorfeast.data.network

import com.keepcoding.flavorfeast.model.CategoryRemote
import com.keepcoding.flavorfeast.model.MealRemote
import com.keepcoding.flavorfeast.model.SingleAreaRemote

interface NetworkDataSourceInterface {

    suspend fun getRandomMeal(): Result<MealRemote>
    suspend fun getAllCategories(): Result<List<CategoryRemote>>
    suspend fun getAllAreas(): Result<List<SingleAreaRemote>>
}