package com.example.uwavetask.network

import com.example.uwavetask.model.ProductModel

interface RemoteDataSource {
    suspend fun getDataFromApi(): ProductModel
}