package com.keepcoding.flavorfeast.data

import com.keepcoding.flavorfeast.data.network.NetworkDataSourceInterface
import com.keepcoding.flavorfeast.model.MealUI
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
}