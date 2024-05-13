package com.keepcoding.flavorfeast.data.network

import com.keepcoding.flavorfeast.data.network.api.MealApi
import com.keepcoding.flavorfeast.model.CategoryRemote
import com.keepcoding.flavorfeast.model.IngredientsRemote
import com.keepcoding.flavorfeast.model.MealRemote
import com.keepcoding.flavorfeast.model.SingleAreaRemote
import com.keepcoding.flavorfeast.model.SingleMealRemote
import com.keepcoding.flavorfeast.model.enums.BadRequestException
import com.keepcoding.flavorfeast.model.enums.NoDataException
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val api: MealApi,
) : NetworkDataSourceInterface {

    override suspend fun getRandomMeal(): Result<MealRemote> {
        val response = api.getRandomMeal()

        if (response.isSuccessful) {
            response.body()?.meals?.let {
                return Result.success(it[0])
            }
            
            return Result.failure(NoDataException())
        } else {
            return Result.failure(BadRequestException(response.code()))
        }
    }

    override suspend fun getAllCategories(): Result<List<CategoryRemote>> {
        val response = api.getAllCategories()

        if (response.isSuccessful) {
            response.body()?.categories?.let {
                return Result.success(it)
            }

            return Result.failure(NoDataException())
        } else {
            return Result.failure(BadRequestException(response.code()))
        }
    }

    override suspend fun getAllAreas(): Result<List<SingleAreaRemote>> {
        val response = api.getAllAreas()

        if (response.isSuccessful) {
            response.body()?.meals?.let {
                return Result.success(it)
            }

            return Result.failure(NoDataException())
        } else {
            return Result.failure(BadRequestException(response.code()))
        }
    }

    override suspend fun getAllIngredients(): Result<List<IngredientsRemote>> {
        val response = api.getAllIngredients()

        if (response.isSuccessful) {
            response.body()?.meals?.let {
                return Result.success(it)
            }

            return Result.failure(NoDataException())
        } else {
            return Result.failure(BadRequestException(response.code()))
        }
    }
    
    override suspend fun getByCategory(category: String): Result<List<SingleMealRemote>> {
        val response = api.getByCategory(category)

        if (response.isSuccessful) {
            response.body()?.meals?.let {
                return Result.success(it)
            }

            return Result.failure(NoDataException())
        } else {
            return Result.failure(BadRequestException(response.code()))
        }
    }
    
    override suspend fun getByArea(area: String): Result<List<SingleMealRemote>> {
        val response = api.getByArea(area)

        if (response.isSuccessful) {
            response.body()?.meals?.let {
                return Result.success(it)
            }

            return Result.failure(NoDataException())
        } else {
            return Result.failure(BadRequestException(response.code()))
        }
    }

    override suspend fun getByIngredient(ingredient: String): Result<List<SingleMealRemote>> {
        val response = api.getByIngredient(ingredient)

        if (response.isSuccessful) {
            response.body()?.meals?.let {
                return Result.success(it)
            }

            return Result.failure(NoDataException())
        } else {
            return Result.failure(BadRequestException(response.code()))
        }
    }

    override suspend fun getByID(id: String): Result<MealRemote> {
        val response = api.getById(id)

        if (response.isSuccessful) {
            response.body()?.meals?.let {
                return Result.success(it[0])
            }

            return Result.failure(NoDataException())
        } else {
            return Result.failure(BadRequestException(response.code()))
        }
    }
}