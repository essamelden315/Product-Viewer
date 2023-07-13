package com.example.uwavetask.network

import com.example.uwavetask.model.ProductModelItem

class ProductClient private constructor():RemoteDataSource {
    companion object{
        private val remoteDataSource = ProductClient()
        fun getInstance():ProductClient{
            return remoteDataSource
        }
    }
    override suspend fun getDataFromApi(): List<ProductModelItem> {
      return RetrofitClass.api_service.getDataFromApi()
    }
}