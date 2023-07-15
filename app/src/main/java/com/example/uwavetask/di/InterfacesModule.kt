package com.example.uwavetask.di

import com.example.uwavetask.network.ProductClient
import com.example.uwavetask.network.RemoteDataSource
import com.example.uwavetask.repository.Repository
import com.example.uwavetask.repository.RepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InterfacesModule {
    @Binds
    @Singleton
    abstract fun remoteDataSourceInjection(
        remoteSourceImpl: ProductClient
    ): RemoteDataSource
    @Binds
    @Singleton
    abstract fun repoInjection(
        repoImpl: Repository
    ): RepositoryInterface
}