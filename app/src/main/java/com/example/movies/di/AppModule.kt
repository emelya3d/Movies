package com.example.movies.di

import com.example.movies.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)//SingletonComponent::class объект будет создан в одном экземпляре
object AppModule {
    @Provides
    fun baseUrl() = "http://api.tvmaze.com/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): ApiService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create()) // Gson конвертер
        .build()
        .create(ApiService::class.java)

}
