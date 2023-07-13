package com.example.uwavetask.network

import com.example.uwavetask.model.ProductModelItem
import javax.inject.Inject

class ProductClient @Inject constructor(private val myApi:ProductApiService):RemoteDataSource {
    override suspend fun getDataFromApi(): List<ProductModelItem> {
      return myApi.getDataFromApi()
    }
}