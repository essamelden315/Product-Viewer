package com.example.uwavetask.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.uwavetask.model.Product
import com.example.uwavetask.model.ProductModelItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("select * from products")
    fun getDataFromDataBase(): Flow<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProductsDataIntoDataBase(productModel : List<Product>)
}