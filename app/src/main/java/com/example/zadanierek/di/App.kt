package com.example.zadanierek.di

import android.app.Application
import com.example.zadanierek.data.repository.ApiRepository
import com.example.zadanierek.data.repository.ApiRepositoryDaily
import com.example.zadanierek.infrastructure.common.Constants
import com.example.zadanierek.infrastructure.remote.Api
import com.example.zadanierek.infrastructure.remote.ApiSecond
import com.example.zadanierek.infrastructure.remote.implementation.ApiRepositoryDailyImpl
import com.example.zadanierek.infrastructure.remote.implementation.ApiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class App {

    @Provides
    @Singleton
    fun provideApi(): Api {
        val request = Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request().newBuilder()
                chain.proceed(request.build())
            }.build())
            .baseUrl(Constants.apiKey2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
        return request
    }
    @Provides
    @Singleton
    fun provideSecondApi(): ApiSecond {
        val request = Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request().newBuilder()
                chain.proceed(request.build())
            }.build())
            .baseUrl(Constants.apiKey1)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiSecond::class.java)
        return request
    }

    @Provides
    fun provideRepository(api: Api): ApiRepository {
        return ApiRepositoryImpl(api)
    }

    @Provides
    fun provideDailyRepository(api: ApiSecond): ApiRepositoryDaily {
        return ApiRepositoryDailyImpl(api)
    }
}