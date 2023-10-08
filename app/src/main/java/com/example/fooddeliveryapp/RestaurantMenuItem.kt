package com.example.fooddeliveryapp

data class RestaurantMenuItem (
    var restaurant: Restaurant,
    var title: String,
    var description: String,
    var price: Double,
    var count: Int = 0
) {

}