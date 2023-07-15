package com.example.uwavetask.di

import com.example.uwavetask.network.ProductClient
import com.example.uwavetask.network.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfacesModule {
    @Binds
    abstract fun remoteDataSourceInjection(
        remoteSourceImpl: ProductClient
    ): RemoteDataSource
}