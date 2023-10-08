package com.example.fooddeliveryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantRecyclerViewAdapter(val restaurants : ArrayList<Restaurant>, val posterTable : MutableMap<String, Int>) : RecyclerView.Adapter<RestaurantRecyclerViewAdapter.RestaurantViewHolder>() {

    var listener: ItemOnClickListener? = null

    interface ItemOnClickListener {
        fun onItemClickedFromAdapter(restaurant: Restaurant)
    }

    fun setItemOnClickListener(listener: ItemOnClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantRecyclerViewAdapter.RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: RestaurantRecyclerViewAdapter.RestaurantViewHolder,
        position: Int
    ) {
        val restaurant = restaurants[position]
        holder.restaurantPoster.setImageResource(posterTable[restaurant.title]!!)
        holder.restaurantTitle.text = restaurant.title
        holder.restaurantDescription.text = restaurant.description
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    inner class RestaurantViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val restaurantPoster = view.findViewById<ImageView>(R.id.poster_imageView)
        val restaurantTitle = view.findViewById<TextView>(R.id.title_textView)
        val restaurantDescription = view.findViewById<TextView>(R.id.description_textView)
        init {
            view.setOnClickListener {
                if (listener != null) {
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        listener!!.onItemClickedFromAdapter(restaurants[adapterPosition])
                    }
                }
            }
        }
    }
}