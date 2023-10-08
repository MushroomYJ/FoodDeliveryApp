package com.example.fooddeliveryapp

class RestaurantData {
    companion object {
        val restaurants : ArrayList<Restaurant>
            get() {
                val list = ArrayList<Restaurant>()
                list.add(Restaurant("Burger King", "Fast food restaurant including burgers, fries, etc."))
                list.add(Restaurant("Dunkin' Donuts", "Sells coffee, doughnuts, beverages, etc."))
                return list
            }

        val restaurantPosterTable : MutableMap<String, Int>
            get() {
                val map: MutableMap<String, Int> = mutableMapOf()
                map["Burger King"] = R.drawable.burgerking
                map["Dunkin' Donuts"] = R.drawable.dunkindonuts
                return map
            }

    }
}