package com.example.uwavetask.detailsScreen.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uwavetask.R
import com.example.uwavetask.databinding.FragmentDetailsBinding
import com.example.uwavetask.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var detailsBinding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailsBinding = FragmentDetailsBinding.inflate(inflater)
        val productName = (arguments?.getString("productName"))
        val productImage = (arguments?.getString("productImage"))
        detailsBinding.productName = productName
        detailsBinding.productImage = productImage
        return detailsBinding.root
    }
}