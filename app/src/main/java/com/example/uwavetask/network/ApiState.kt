package com.example.uwavetask.network

sealed class ApiState {
    class Success<T>(val date: T) : ApiState()
    class Failure(val error: Throwable) : ApiState()
    object Loading : ApiState()
}