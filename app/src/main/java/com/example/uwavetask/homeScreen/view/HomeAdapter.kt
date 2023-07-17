package com.example.uwavetask.homeScreen.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.OvershootInterpolator
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.core.text.TextUtilsCompat
import androidx.core.view.ViewCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uwavetask.R
import com.example.uwavetask.databinding.ProductCardBinding
import com.example.uwavetask.model.Product
import com.example.uwavetask.model.ProductModelItem
import java.util.*

class HomeAdapter(private var products:List<Product>,val delegate:Delegation):RecyclerView.Adapter<HomeAdapter.ProductViewHolder>()  {
    private var lastPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductCardBinding.inflate( LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return products.size
    }
    fun updateList(updatedList:List<Product>){
        products = updatedList
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
        setAnimation(holder.itemView, position)
        holder.productBinding.root.setOnClickListener {
            delegate.gotoDetailsScreen(product)
        }
    }


    private fun setAnimation(view: View, position: Int) {
        if (position > lastPosition) {
            val startX = if (isRTL()) view.width.toFloat() else -view.width.toFloat()
            val endX = 0f
            val animation = TranslateAnimation(startX, endX, 0f, 0f)
            animation.duration = 500
            animation.interpolator = OvershootInterpolator()
            view.startAnimation(animation)
            lastPosition = position
        }
    }

    private fun isRTL(): Boolean {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == ViewCompat.LAYOUT_DIRECTION_RTL
    }

    inner class ProductViewHolder( val productBinding: ProductCardBinding) : RecyclerView.ViewHolder(productBinding.root) {
        fun bind(product: Product) {
            productBinding.productItem = product
        }
    }

}
