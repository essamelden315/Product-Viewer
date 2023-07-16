package com.example.uwavetask.homeScreen.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.uwavetask.R
import com.example.uwavetask.databinding.FragmentHomeBinding
import com.example.uwavetask.homeScreen.viewModel.HomeViewModel
import com.example.uwavetask.model.Product
import com.example.uwavetask.model.ProductModelItem
import com.example.uwavetask.network.ApiState
import com.example.uwavetask.network.networkListner.NetworkListener
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(),Delegation {
    private lateinit var binding:FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        homeAdapter=HomeAdapter(listOf(),this)
        binding.homeRV.apply {
            adapter = homeAdapter
            layoutManager =  GridLayoutManager(requireContext(), 2)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataFromApiOrFromDatabase()
        apiObservation()
        databaseObservation()
    }
    override fun onResume() {
        super.onResume()
        binding.homeSwipeLayout.setOnRefreshListener {
            getDataFromApiOrFromDatabase()
            binding.homeSwipeLayout.isRefreshing=false
        }
    }
    private fun getDataFromApiOrFromDatabase(){
        if(NetworkListener.getConnectivity(requireContext())){
            homeViewModel.getDataFromApi()
        }else{
            homeViewModel.getDataFromDataBase()
            binding.errorMsg.text="No Internet Connection"
            binding.errorMsg.visibility = View.VISIBLE
            Snackbar.make(requireView(),"no internet connection",Snackbar.LENGTH_SHORT).show()
        }

    }
    private fun databaseObservation(){
        lifecycleScope.launch {
            homeViewModel.localData.collect{result->
                when (result){
                    is ApiState.Loading->{
                        binding.progressBar.visibility = View.VISIBLE
                        binding.errorMsg.visibility = View.GONE
                    }
                    is ApiState.Success<*>->{
                        binding.progressBar.visibility = View.GONE
                        val productsList =result.date as List<Product>
                        homeAdapter.updateList(productsList)
                    }
                    is ApiState.Failure->{
                        binding.progressBar.visibility = View.GONE
                        binding.errorMsg.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
    private fun apiObservation(){
        lifecycleScope.launch {
            homeViewModel.accessProductsData.collect{result->
                when (result){
                    is ApiState.Loading->{
                        binding.errorMsg.visibility = View.GONE
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is ApiState.Success<*>->{
                        binding.progressBar.visibility = View.GONE
                        val productsList =result.date as List<Product>
                        homeAdapter.updateList(productsList)
                    }
                    is ApiState.Failure->{
                        binding.progressBar.visibility = View.GONE
                        binding.errorMsg.visibility = View.VISIBLE

                    }
                }
            }
        }
    }

    override fun gotoDetailsScreen(product: Product) {
        val bundle = Bundle().apply {
           putString("productName",product.name)
           putString("productImage",product.image_url)
        }
       Navigation.findNavController(requireView()).navigate(R.id.fromHomeToDetails,bundle)
    }
}