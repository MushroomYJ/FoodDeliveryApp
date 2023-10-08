package com.example.fooddeliveryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantMenuRecyclerViewAdapter(val restaurantMenuItems : ArrayList<RestaurantMenuItem>, val posterTable : MutableMap<String, Int>) : RecyclerView.Adapter<RestaurantMenuRecyclerViewAdapter.RestaurantMenuViewHolder>() {

    var listener: RestaurantMenuRecyclerViewAdapter.ItemAddToCartOnclickListener? = null

    interface ItemAddToCartOnclickListener {
        fun onItemAddToCartClickedFromAdapter(restaurantMenuItem: RestaurantMenuItem)
    }

    fun setItemAddToCartOnclickListener(listener: ItemAddToCartOnclickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantMenuRecyclerViewAdapter.RestaurantMenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_menu_item, parent, false)
        return RestaurantMenuViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: RestaurantMenuRecyclerViewAdapter.RestaurantMenuViewHolder,
        position: Int
    ) {
        val restaurantMenuItem = restaurantMenuItems[position]
        holder.restaurantMenuItemPoster.setImageResource(posterTable[restaurantMenuItem.title]!!)
        holder.restaurantMenuItemPrice.text = "$" + restaurantMenuItem.price.toString()
        holder.restaurantMenuItemTitle.text = restaurantMenuItem.title
        holder.restaurantMenuItemDescription.text = restaurantMenuItem.description
    }

    override fun getItemCount(): Int {
        return restaurantMenuItems.size
    }

    inner class RestaurantMenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val restaurantMenuItemPoster = view.findViewById<ImageView>(R.id.poster_imageView)
        val restaurantMenuItemPrice = view.findViewById<TextView>(R.id.price_textView)
        val restaurantMenuItemTitle = view.findViewById<TextView>(R.id.title_textView)
        val restaurantMenuItemDescription = view.findViewById<TextView>(R.id.description_textView)
        val restaurantMenuItemAddToCartButton = view.findViewById<Button>(R.id.addToCart_button)
        init {
            restaurantMenuItemAddToCartButton.setOnClickListener {
                if (listener != null) {
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        listener!!.onItemAddToCartClickedFromAdapter(restaurantMenuItems[adapterPosition])
                    }
                }
            }
        }
    }
}