package com.example.uwavetask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.uwavetask.model.Product
import com.example.uwavetask.model.ProductModelItem

@Database([Product::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun productDao():ProductDao
    companion object{
        @Volatile
        private var myInstance:AppDatabase? = null
        fun getInstance(context: Context):AppDatabase{
            return myInstance ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, "market"
                ).build()
                myInstance = instance
                instance
            }
        }
    }
}