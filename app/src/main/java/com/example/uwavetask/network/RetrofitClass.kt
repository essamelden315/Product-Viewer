package com.example.uwavetask.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClass {

        private val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("http://www.nweave.com/wp-content/uploads/2012/09/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api_service: ProductApiService by lazy {
            retrofit.create(ProductApiService::class.java)
        }

}