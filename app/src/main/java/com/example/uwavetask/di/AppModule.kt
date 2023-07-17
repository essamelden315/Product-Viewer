package com.example.uwavetask.di

import android.content.Context
import com.example.uwavetask.database.AppDatabase
import com.example.uwavetask.database.ProductDao
import com.example.uwavetask.network.ProductApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    @Provides
    @Singleton
    fun getProductDaoInstance(@ApplicationContext context: Context):ProductDao{
        return AppDatabase.getInstance(context).productDao()
    }

}