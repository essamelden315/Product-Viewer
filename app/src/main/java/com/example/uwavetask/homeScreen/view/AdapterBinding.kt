package com.example.uwavetask.homeScreen.view

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.uwavetask.R


object AdapterBinding {
    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(view: ImageView, imageUrl: String) {
        Glide.with(view)
            .load(imageUrl)
            .placeholder(R.drawable.empty_cart)
            .into(view)


    }
}
