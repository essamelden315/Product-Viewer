package com.example.uwavetask.model

data class Product(
    val description: String,
    val id: String,
    val image_url: String,
    val name: String,
    val price: String,
    val product_type_id: Any,
    val shopping_cart_item_id: Any,
    val shopping_list_item_id: Any,
    val unit_price: Any
)