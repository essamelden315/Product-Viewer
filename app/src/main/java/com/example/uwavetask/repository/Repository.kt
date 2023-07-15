package com.example.uwavetask.repository

import android.util.Log
import com.example.uwavetask.model.ProductModelItem
import com.example.uwavetask.network.ApiState
import com.example.uwavetask.network.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(private val remote:RemoteDataSource):RepositoryInterface {
    override suspend fun getDataFromApi(): ApiState {
        return try {
            val res = remote.getDataFromApi()
            ApiState.Success(res)
        }catch (e:Exception){
            Log.i("essam data error", ""+ e.message)
            ApiState.Failure(e)
        }
    }

}