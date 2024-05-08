package com.keepcoding.flavorfeast.di

import com.keepcoding.flavorfeast.data.network.NetworkDataSource
import com.keepcoding.flavorfeast.data.network.NetworkDataSourceInterface
import com.keepcoding.flavorfeast.data.network.api.MealApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providesNetworkDataSource(networkDataSource: NetworkDataSource): NetworkDataSourceInterface {
        return networkDataSource
    }

    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://themealdb.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun providesDragonBallApi(retrofit: Retrofit): MealApi {
        return retrofit.create(MealApi::class.java)
    }
}