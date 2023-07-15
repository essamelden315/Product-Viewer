package com.example.uwavetask.repository

import com.example.uwavetask.model.ProductModelItem
import com.example.uwavetask.network.ApiState

interface RepositoryInterface {
    suspend fun getDataFromApi(): ApiState
}