package com.example.uwavetask.network

import com.example.uwavetask.model.ProductModel
import retrofit2.http.GET

interface ProductApiService {
    @GET("featured.txt")
    suspend fun getDataFromApi():ProductModel
}