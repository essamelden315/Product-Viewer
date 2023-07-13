package com.example.uwavetask.network

import com.example.uwavetask.model.ProductModelItem

interface RemoteDataSource {
    suspend fun getDataFromApi(): List<ProductModelItem>
}