package com.example.fooddeliveryapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RestaurantMenuActivity : AppCompatActivity(), RestaurantMenuRecyclerViewAdapter.ItemAddToCartOnclickListener {

    companion object {
        const val RESTAURANT = "Restaurant"
    }

    private val restaurantMenuItems = RestaurantMenuItemData.restaurantMenuItems

    private lateinit var descriptionTextView: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton

    private val adapter = RestaurantMenuRecyclerViewAdapter(restaurantMenuItems, RestaurantMenuItemData.restaurantPosterTable)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_menu)

        descriptionTextView = findViewById(R.id.description_textView)
        val restaurant = intent.getSerializableExtra("Restaurant") as Restaurant
        descriptionTextView.text = restaurant.description
        actionBar?.title = restaurant.title

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        floatingActionButton = findViewById(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        adapter.setItemAddToCartOnclickListener(this)
        recyclerView.adapter = adapter
    }

    override fun onItemAddToCartClickedFromAdapter(restaurantMenuItem: RestaurantMenuItem) {
//        if (addToCart(restaurantMenuItem)) {
//            Toast.makeText(applicationContext, "Added to Cart", Toast.LENGTH_LONG).show()
//        } else {
//            Toast.makeText(applicationContext, "An error occurred. Please try again later.", Toast.LENGTH_LONG).show()
//        }
    }

//    private fun addToCart(restaurantMenuItem: RestaurantMenuItem) : Boolean {
//
//    }
}