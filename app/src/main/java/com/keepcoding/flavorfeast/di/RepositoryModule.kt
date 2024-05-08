package com.keepcoding.flavorfeast.di

import com.keepcoding.flavorfeast.data.Repository
import com.keepcoding.flavorfeast.data.RepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun providesRepository(repository: Repository): RepositoryInterface {
        return repository
    }
}