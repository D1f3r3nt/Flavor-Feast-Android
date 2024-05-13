package com.keepcoding.flavorfeast.data.network

import com.keepcoding.flavorfeast.model.CategoryRemote
import com.keepcoding.flavorfeast.model.IngredientsRemote
import com.keepcoding.flavorfeast.model.MealRemote
import com.keepcoding.flavorfeast.model.SingleAreaRemote
import com.keepcoding.flavorfeast.model.SingleMealRemote

interface NetworkDataSourceInterface {

    suspend fun getRandomMeal(): Result<MealRemote>
    suspend fun getAllCategories(): Result<List<CategoryRemote>>
    suspend fun getAllAreas(): Result<List<SingleAreaRemote>>
    suspend fun getAllIngredients(): Result<List<IngredientsRemote>>
    suspend fun getByCategory(category: String): Result<List<SingleMealRemote>>
    suspend fun getByArea(area: String): Result<List<SingleMealRemote>>
    suspend fun getByIngredient(ingredient: String): Result<List<SingleMealRemote>>
}