package com.example.uwavetask.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "products")
data class Product(
    val description: String,
    @PrimaryKey
    val id: String,
    val image_url: String,
    val name: String,
    val price: String,
    val product_type_id:String?,
    val shopping_cart_item_id: String?,
    val shopping_list_item_id: String?,
    val unit_price: String?
):java.io.Serializable