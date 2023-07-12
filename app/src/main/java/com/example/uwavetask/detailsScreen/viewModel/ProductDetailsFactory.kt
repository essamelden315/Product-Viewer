package com.example.uwavetask.detailsScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uwavetask.model.Repository

class ProductDetailsFactory(private val repo: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ProductDetailsViewModel::class.java)) {
            ProductDetailsViewModel(repo) as T
        } else {
            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}