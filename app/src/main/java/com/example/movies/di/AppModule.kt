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
    const val BASE_URL="http://api/tvmaze.com"
    @Provides
    @Singleton
    fun provideRetrofit():ApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

}