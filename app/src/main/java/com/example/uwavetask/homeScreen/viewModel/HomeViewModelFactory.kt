package com.example.uwavetask.homeScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uwavetask.repository.RepositoryInterface

class HomeViewModelFactory (private val irepo: RepositoryInterface) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            HomeViewModel(irepo) as T
        } else {
            throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}