package com.example.fooddeliveryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartRecyclerViewAdapter(val cartItems : ArrayList<RestaurantMenuItem>) : RecyclerView.Adapter<CartRecyclerViewAdapter.CartViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartRecyclerViewAdapter.CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartRecyclerViewAdapter.CartViewHolder, position: Int) {
        val cartItem = cartItems[position]
        // holder.cartItemPoster.setImageResource()
        holder.cartItemTotalPrice.text = "$" + (cartItem.price * cartItem.count).toString()
        holder.cartTitle.text = cartItem.title
        holder.cartCount.text = cartItem.count.toString()
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    inner class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cartItemPoster = view.findViewById<ImageView>(R.id.poster_imageView)
        val cartItemTotalPrice = view.findViewById<TextView>(R.id.price_textView)
        val cartTitle = view.findViewById<TextView>(R.id.title_textView)
        val cartCount = view.findViewById<TextView>(R.id.count_textView)
    }
}