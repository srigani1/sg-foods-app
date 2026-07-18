package com.sgfoods.app.data

import com.sgfoods.app.R

object FoodRepository {
    fun getFoodItems(): List<FoodItem> {
        return listOf(
            FoodItem(1, "Biryani", "Fragrant basmati rice with spices", 350.0, R.drawable.ic_food_biryani, 4.5, "Rice"),
            FoodItem(2, "Butter Chicken", "Creamy tomato curry with chicken", 450.0, R.drawable.ic_food_chicken, 4.7, "Curry"),
            FoodItem(3, "Pizza Margherita", "Classic cheese and tomato pizza", 300.0, R.drawable.ic_food_pizza, 4.4, "Pizza"),
            FoodItem(4, "Samosa", "Crispy fried pastry with filling", 50.0, R.drawable.ic_food_samosa, 4.3, "Snacks"),
            FoodItem(5, "Dosa", "South Indian crepe with sambar", 150.0, R.drawable.ic_food_dosa, 4.6, "South Indian"),
            FoodItem(6, "Paneer Tikka", "Grilled cottage cheese with spices", 250.0, R.drawable.ic_food_paneer, 4.5, "Appetizer")
        )
    }
}
