package com.keepcoding.flavorfeast.data.network.api

import com.keepcoding.flavorfeast.data.network.response.GetAllAreas
import com.keepcoding.flavorfeast.data.network.response.GetAllCategories
import com.keepcoding.flavorfeast.data.network.response.GetRandomResponse
import retrofit2.Response
import retrofit2.http.GET

interface MealApi {
    
    @GET("/api/json/v1/1/random.php")
    suspend fun getRandomMeal(): Response<GetRandomResponse>

    @GET("/api/json/v1/1/categories.php")
    suspend fun getAllCategories(): Response<GetAllCategories>

    @GET("/api/json/v1/1/list.php?a=list")
    suspend fun getAllAreas(): Response<GetAllAreas>
}