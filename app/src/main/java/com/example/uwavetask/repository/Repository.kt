package com.example.uwavetask.repository

import android.util.Log
import com.example.uwavetask.database.LocalDataSource
import com.example.uwavetask.model.Product
import com.example.uwavetask.model.ProductModelItem
import com.example.uwavetask.network.ApiState
import com.example.uwavetask.network.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(private val remote:RemoteDataSource,private val local: LocalDataSource):RepositoryInterface {
    override suspend fun getDataFromApi()=
        try {
            val res = remote.getDataFromApi().map {
                it.Product
            }
            insertDataIntoDataBase(res)
            ApiState.Success(res)
        }catch (e:Exception){
            Log.i("essam data error", ""+ e.message)
            ApiState.Failure(e)
        }

    override suspend fun getDataFromDataBase()= local.getDataFromDatabase()

    override suspend fun insertDataIntoDataBase(productModel: List<Product>) {
        local.insertIntoDatabase(productModel)
    }

}