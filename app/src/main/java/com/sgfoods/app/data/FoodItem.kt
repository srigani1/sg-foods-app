package com.sgfoods.app.data

data class FoodItem(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageResId: Int,
    val rating: Double,
    val category: String
)
