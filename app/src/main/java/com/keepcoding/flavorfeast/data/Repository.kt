package com.keepcoding.flavorfeast.data

import com.keepcoding.flavorfeast.data.network.NetworkDataSourceInterface
import com.keepcoding.flavorfeast.model.CategoryUI
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.model.SingleAreaUI
import com.keepcoding.flavorfeast.model.toUI
import javax.inject.Inject

class Repository @Inject constructor(
    private val networkDataSource: NetworkDataSourceInterface,
) : RepositoryInterface {
    
    override suspend fun getRandomMeal() : Result<MealUI> {
        val result = networkDataSource.getRandomMeal()

        val meal = result.getOrElse { 
            return Result.failure(it)
        }.toUI()
        
        return Result.success(meal)
    }

    override suspend fun getAllCategories() : Result<List<CategoryUI>> {
        val result = networkDataSource.getAllCategories()

        val categories = result.getOrElse {
            return Result.failure(it)
        }.toUI()

        return Result.success(categories)
    }

    override suspend fun getAllAreas() : Result<List<SingleAreaUI>> {
        val result = networkDataSource.getAllAreas()

        val categories = result.getOrElse {
            return Result.failure(it)
        }.toUI()

        return Result.success(categories)
    }
}