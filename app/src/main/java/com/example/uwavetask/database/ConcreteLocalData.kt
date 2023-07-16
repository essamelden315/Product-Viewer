package com.example.uwavetask.database

import com.example.uwavetask.model.Product
import com.example.uwavetask.model.ProductModelItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ConcreteLocalData @Inject constructor(private val local:ProductDao):LocalDataSource {

    override suspend fun getDataFromDatabase()=local.getDataFromDataBase()
    override suspend fun insertIntoDatabase(productModel : List<Product>){
        local.insertProductsDataIntoDataBase(productModel)
    }
}