package com.example.uwavetask.database

import com.example.uwavetask.model.Product
import com.example.uwavetask.model.ProductModelItem
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun getDataFromDatabase(): Flow<List<Product>>
    suspend fun insertIntoDatabase(productModel : List<Product>)
}