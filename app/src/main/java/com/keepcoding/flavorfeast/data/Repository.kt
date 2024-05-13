package com.keepcoding.flavorfeast.data

import com.keepcoding.flavorfeast.data.network.NetworkDataSourceInterface
import com.keepcoding.flavorfeast.model.CategoryUI
import com.keepcoding.flavorfeast.model.IngredientsUI
import com.keepcoding.flavorfeast.model.MealUI
import com.keepcoding.flavorfeast.model.SingleAreaUI
import com.keepcoding.flavorfeast.model.SingleMealUI
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

    override suspend fun getAllIngredients() : Result<List<IngredientsUI>> {
        val result = networkDataSource.getAllIngredients()

        val ingredients = result.getOrElse {
            return Result.failure(it)
        }.toUI()

        return Result.success(ingredients)
    }
    
    override suspend fun getByCategory(category: String) : Result<List<SingleMealUI>> {
        val result = networkDataSource.getByCategory(category)

        val meals = result.getOrElse {
            return Result.failure(it)
        }.toUI()

        return Result.success(meals)
    }

    override suspend fun getByArea(area: String) : Result<List<SingleMealUI>> {
        val result = networkDataSource.getByArea(area)

        val meals = result.getOrElse {
            return Result.failure(it)
        }.toUI()

        return Result.success(meals)
    }

    override suspend fun getByIngredient(ingredient: String) : Result<List<SingleMealUI>> {
        val result = networkDataSource.getByIngredient(ingredient)

        val meals = result.getOrElse {
            return Result.failure(it)
        }.toUI()

        return Result.success(meals)
    }
}