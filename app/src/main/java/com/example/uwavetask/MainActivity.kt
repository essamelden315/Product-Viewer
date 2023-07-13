package com.example.uwavetask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.uwavetask.model.Repository
import com.example.uwavetask.network.RemoteDataSource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var remote:RemoteDataSource
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var repository = Repository(remote)
        lifecycleScope.launch(Dispatchers.IO) {
            repository.getDataFromApi()
        }
    }
}