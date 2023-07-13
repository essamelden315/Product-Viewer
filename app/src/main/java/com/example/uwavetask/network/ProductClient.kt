package com.example.uwavetask.network

import com.example.uwavetask.model.ProductModel

class ProductClient private constructor():RemoteDataSource {
    companion object{
        private val remoteDataSource = ProductClient()
        fun getInstance():ProductClient{
            return remoteDataSource
        }
    }
    override suspend fun getDataFromApi(): ProductModel {
      return RetrofitClass.api_service.getDataFromApi()
    }
}