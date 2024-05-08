package com.keepcoding.flavorfeast.data.network.api

import com.keepcoding.flavorfeast.data.network.response.GetRandomResponse
import retrofit2.Response
import retrofit2.http.GET

interface MealApi {
    
    @GET("/api/json/v1/1/random.php")
    suspend fun getRandomMeal(): Response<GetRandomResponse>
}