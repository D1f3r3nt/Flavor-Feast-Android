package com.keepcoding.flavorfeast.data.network.api

import com.keepcoding.flavorfeast.data.network.response.GetAllAreasResponse
import com.keepcoding.flavorfeast.data.network.response.GetAllCategoriesResponse
import com.keepcoding.flavorfeast.data.network.response.GetAllIngredientsResponse
import com.keepcoding.flavorfeast.data.network.response.GetByAreaResponse
import com.keepcoding.flavorfeast.data.network.response.GetByCategoryResponse
import com.keepcoding.flavorfeast.data.network.response.GetByIdResponse
import com.keepcoding.flavorfeast.data.network.response.GetByNameResponse
import com.keepcoding.flavorfeast.data.network.response.GetRandomResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    
    @GET("/api/json/v1/1/random.php")
    suspend fun getRandomMeal(): Response<GetRandomResponse>

    @GET("/api/json/v1/1/categories.php")
    suspend fun getAllCategories(): Response<GetAllCategoriesResponse>

    @GET("/api/json/v1/1/list.php?a=list")
    suspend fun getAllAreas(): Response<GetAllAreasResponse>

    @GET("/api/json/v1/1/list.php?i=list")
    suspend fun getAllIngredients(): Response<GetAllIngredientsResponse>
    
    @GET("/api/json/v1/1/filter.php")
    suspend fun getByCategory(@Query("c") category: String): Response<GetByCategoryResponse>

    @GET("/api/json/v1/1/filter.php")
    suspend fun getByArea(@Query("a") area: String): Response<GetByAreaResponse>

    @GET("/api/json/v1/1/filter.php")
    suspend fun getByIngredient(@Query("i") ingredient: String): Response<GetByAreaResponse>
    
    @GET("/api/json/v1/1/lookup.php")
    suspend fun getById(@Query("i") id: String): Response<GetByIdResponse>

    @GET("/api/json/v1/1/search.php")
    suspend fun getByName(@Query("s") searchText: String): Response<GetByNameResponse>
}