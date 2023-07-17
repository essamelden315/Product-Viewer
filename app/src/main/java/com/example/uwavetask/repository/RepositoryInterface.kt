package com.example.uwavetask.repository

import com.example.uwavetask.model.Product
import com.example.uwavetask.model.ProductModelItem
import com.example.uwavetask.network.ApiState
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {
    suspend fun getDataFromApi(): ApiState
    suspend fun getDataFromDataBase(): Flow<List<Product>>
    suspend fun insertDataIntoDataBase(productModel : List<Product>)
}