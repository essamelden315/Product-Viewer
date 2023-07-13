package com.example.uwavetask.model

import android.util.Log
import com.example.uwavetask.network.ProductClient
import com.example.uwavetask.network.RemoteDataSource

class Repository:RemoteDataSource {
    private val remote = ProductClient.getInstance()
    override suspend fun getDataFromApi(): List<ProductModelItem> {
        return try {
            Log.i("essam data", ""+ (remote.getDataFromApi()).size)
            remote.getDataFromApi()
        }catch (e:Exception){
            Log.i("essam data error", ""+ e.message)
            return listOf()
        }
    }

}