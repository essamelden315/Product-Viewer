package com.example.uwavetask.di

import com.example.uwavetask.network.ProductApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun getMyApiServiceInstance():ProductApiService{
        return Retrofit.Builder().baseUrl("http://www.nweave.com/wp-content/uploads/2012/09/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ProductApiService::class.java)
    }


}