package com.example.fooddeliveryapp

class RestaurantMenuItemData {
    companion object {
        val restaurantMenuItems : ArrayList<RestaurantMenuItem>
            get() {
                val list = ArrayList<RestaurantMenuItem>()
                list.add(RestaurantMenuItem(RestaurantData.restaurants[0], "Whopper", "657 Cal.", 7.17))
                list.add(RestaurantMenuItem(RestaurantData.restaurants[0], "Original Chicken Sandwich", "662 Cal.", 6.76))
                return list
            }

        val restaurantPosterTable : MutableMap<String, Int>
            get() {
                val map: MutableMap<String, Int> = mutableMapOf()
                map["Whopper"] = R.drawable.burgerking_whopper
                map["Original Chicken Sandwich"] = R.drawable.burgerking_original_chicken_sandwich
                return map
            }

    }
}