package com.example.fooddeliveryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity(), RestaurantRecyclerViewAdapter.ItemOnClickListener {

    private var restaurants = RestaurantData.restaurants

    private lateinit var recyclerView: RecyclerView

    private val adapter = RestaurantRecyclerViewAdapter(restaurants, RestaurantData.restaurantPosterTable)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.setItemOnClickListener(this)
        recyclerView.adapter = adapter
    }

    override fun onItemClickedFromAdapter(restaurant: Restaurant) {
        val intent = Intent(this, RestaurantMenuActivity::class.java)
        intent.putExtra(RestaurantMenuActivity.RESTAURANT, restaurant)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        val searchItem = menu?.findItem(R.id.search_button)
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView
            searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {
                        restaurants.clear()
                        val search = newText.lowercase(Locale.getDefault())
                        RestaurantData.restaurants.forEach {
                            if (it.title.lowercase(Locale.getDefault()).contains(search)) {
                                restaurants.add(it)
                            }
                        }
                        recyclerView.adapter?.notifyDataSetChanged()
                    } else {
                        restaurants = RestaurantData.restaurants
                        recyclerView.adapter?.notifyDataSetChanged()
                    }
                    return true
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }
}