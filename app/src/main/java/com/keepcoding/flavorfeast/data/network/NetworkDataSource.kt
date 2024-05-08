package com.keepcoding.flavorfeast.data.network

import com.keepcoding.flavorfeast.data.network.api.MealApi
import com.keepcoding.flavorfeast.model.MealRemote
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
}