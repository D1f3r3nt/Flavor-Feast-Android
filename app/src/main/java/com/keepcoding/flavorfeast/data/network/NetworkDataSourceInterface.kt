package com.keepcoding.flavorfeast.data.network

import com.keepcoding.flavorfeast.model.MealRemote
import retrofit2.Response

interface NetworkDataSourceInterface {
    
    suspend fun getRandomMeal(): Result<MealRemote>
}