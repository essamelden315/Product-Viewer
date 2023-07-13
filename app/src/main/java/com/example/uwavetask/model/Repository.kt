package com.example.uwavetask.model

import android.util.Log
import com.example.uwavetask.network.ProductClient
import com.example.uwavetask.network.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(private val remote:RemoteDataSource):RemoteDataSource {
    override suspend fun getDataFromApi(): List<ProductModelItem> {
        return try {
            Log.i("essam data", ""+ (remote.getDataFromApi()))
            remote.getDataFromApi()
        }catch (e:Exception){
            Log.i("essam data error", ""+ e.message)
            return listOf()
        }
    }

}