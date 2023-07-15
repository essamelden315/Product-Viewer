package com.example.uwavetask.repository

import android.util.Log
import com.example.uwavetask.model.ProductModelItem
import com.example.uwavetask.network.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(private val remote:RemoteDataSource):RemoteDataSource {
    override suspend fun getDataFromApi(): List<ProductModelItem> {
        return try {
            val res = remote.getDataFromApi()
            Log.i("essam data", ""+res)
            res
        }catch (e:Exception){
            Log.i("essam data error", ""+ e.message)
            return listOf()
        }
    }

}