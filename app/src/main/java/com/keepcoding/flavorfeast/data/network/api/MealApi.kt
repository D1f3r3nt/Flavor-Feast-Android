package com.keepcoding.flavorfeast.data.network.api

import com.keepcoding.flavorfeast.data.network.response.GetAllAreasResponse
import com.keepcoding.flavorfeast.data.network.response.GetAllCategoriesResponse
import com.keepcoding.flavorfeast.data.network.response.GetAllIngredientsResponse
import com.keepcoding.flavorfeast.data.network.response.GetRandomResponse
import retrofit2.Response
import retrofit2.http.GET

interface MealApi {
    
    @GET("/api/json/v1/1/random.php")
    suspend fun getRandomMeal(): Response<GetRandomResponse>

    @GET("/api/json/v1/1/categories.php")
    suspend fun getAllCategories(): Response<GetAllCategoriesResponse>

    @GET("/api/json/v1/1/list.php?a=list")
    suspend fun getAllAreas(): Response<GetAllAreasResponse>

    @GET("/api/json/v1/1/list.php?i=list")
    suspend fun getAllIngredients(): Response<GetAllIngredientsResponse>
}