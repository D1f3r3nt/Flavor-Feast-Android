package com.keepcoding.flavorfeast.data

import com.keepcoding.flavorfeast.model.CategoryUI
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.model.SingleAreaUI

interface RepositoryInterface {

    suspend fun getRandomMeal() : Result<MealUI>
    suspend fun getAllCategories() : Result<List<CategoryUI>>
    suspend fun getAllAreas() : Result<List<SingleAreaUI>>
}