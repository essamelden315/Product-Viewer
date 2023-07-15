package com.example.uwavetask.homeScreen.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uwavetask.R
import com.example.uwavetask.databinding.FragmentHomeBinding
import com.example.uwavetask.network.RemoteDataSource
import com.example.uwavetask.repository.Repository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    @Inject lateinit var remote:RemoteDataSource
    lateinit var repository:Repository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository = Repository(remote)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        lifecycleScope.launch(Dispatchers.Main) {
            homeAdapter=HomeAdapter(repository.getDataFromApi())
            binding.homeRV.apply {
                adapter = homeAdapter
                layoutManager =  GridLayoutManager(requireContext(), 2)
            }
        }



        return binding.root
    }
}