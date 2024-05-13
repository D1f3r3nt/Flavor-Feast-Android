package com.keepcoding.flavorfeast.data

import com.keepcoding.flavorfeast.model.CategoryUI
import com.keepcoding.flavorfeast.model.IngredientsUI
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.model.SingleAreaUI
import com.keepcoding.flavorfeast.model.SingleMealUI

interface RepositoryInterface {

    suspend fun getRandomMeal() : Result<MealUI>
    suspend fun getAllCategories() : Result<List<CategoryUI>>
    suspend fun getAllAreas() : Result<List<SingleAreaUI>>
    suspend fun getAllIngredients() : Result<List<IngredientsUI>>
    suspend fun getByCategory(category: String) : Result<List<SingleMealUI>>
    suspend fun getByArea(area: String) : Result<List<SingleMealUI>>
    suspend fun getByIngredient(ingredient: String) : Result<List<SingleMealUI>>
}