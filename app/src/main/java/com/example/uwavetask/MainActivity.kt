package com.example.uwavetask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.uwavetask.databinding.ActivityMainBinding
import com.example.uwavetask.repository.Repository
import com.example.uwavetask.network.RemoteDataSource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.apply {
            hide()
        }
        val customTitleView = layoutInflater.inflate(R.layout.custem_title, null)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        navHostFragment.findNavController().run {
            binding.toolBar.setupWithNavController(this, AppBarConfiguration(graph))
            binding.toolBar.addView(customTitleView)
            //binding.toolBar.setTitleTextColor(ContextCompat.getColor(applicationContext,R.color.white))

        }
    }
}