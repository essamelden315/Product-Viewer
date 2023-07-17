package com.example.uwavetask.detailsScreen.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        val product = arguments?.getSerializable("Product") as Product
        detailsBinding.product = product
        return detailsBinding.root
    }
}