package com.example.uwavetask.model

import android.util.Log
import com.example.uwavetask.network.ProductClient
import com.example.uwavetask.network.RemoteDataSource

class Repository:RemoteDataSource {
    private val remote = ProductClient.getInstance()
    override suspend fun getDataFromApi(): ProductModel {
        return try {
            Log.i("essam data", ""+ remote.getDataFromApi())
            remote.getDataFromApi()
        }catch (e:Exception){
            Log.i("essam data", ""+ e.message)
            return ProductModel()
        }
    }

}