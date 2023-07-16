package com.example.uwavetask.homeScreen.view

import com.example.uwavetask.model.Product

interface Delegation {
    fun gotoDetailsScreen(product: Product)
}