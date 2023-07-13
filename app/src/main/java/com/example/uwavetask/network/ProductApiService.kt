package com.example.uwavetask.network

import com.example.uwavetask.model.ProductModelItem
import retrofit2.http.GET

interface ProductApiService {
    @GET("featured.txt")
    suspend fun getDataFromApi():List<ProductModelItem>
}