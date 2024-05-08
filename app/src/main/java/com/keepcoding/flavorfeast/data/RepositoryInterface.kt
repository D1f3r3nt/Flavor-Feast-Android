package com.keepcoding.flavorfeast.data

import com.keepcoding.flavorfeast.model.CategoryUI
import com.keepcoding.flavorfeast.model.MealUI

interface RepositoryInterface {

    suspend fun getRandomMeal() : Result<MealUI>
    suspend fun getAllCategories() : Result<List<CategoryUI>>
}