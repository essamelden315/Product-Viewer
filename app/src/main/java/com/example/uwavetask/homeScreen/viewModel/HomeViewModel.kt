package com.example.uwavetask.homeScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uwavetask.network.ApiState
import com.example.uwavetask.repository.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: RepositoryInterface) : ViewModel() {
    private var _productsData = MutableStateFlow<ApiState>(ApiState.Loading)
    var accessProductsData: StateFlow<ApiState> = _productsData

    private var _localData= MutableStateFlow<ApiState>(ApiState.Loading)
    val localData: StateFlow<ApiState> = _localData
    fun getDataFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
                _productsData.value = repo.getDataFromApi()
        }
    }
    fun getDataFromDataBase(){
        viewModelScope.launch(Dispatchers.IO) {
            repo.getDataFromDataBase().catch{e->
                _localData.value = ApiState.Failure(e)
            }.collect{
                _localData.value = ApiState.Success(it)
            }
        }
    }
}
