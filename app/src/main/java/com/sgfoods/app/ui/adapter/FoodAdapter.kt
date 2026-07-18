package com.sgfoods.app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sgfoods.app.data.FoodItem
import com.sgfoods.app.databinding.ItemFoodBinding

class FoodAdapter(private var foodItems: List<FoodItem>) : 
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(private val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(foodItem: FoodItem) {
            binding.apply {
                foodName.text = foodItem.name
                foodDescription.text = foodItem.description
                foodPrice.text = "Rs ${foodItem.price}"
                foodRating.text = "${foodItem.rating} star"
                foodImage.setImageResource(foodItem.imageResId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodItems[position])
    }

    override fun getItemCount(): Int = foodItems.size

    fun updateList(newList: List<FoodItem>) {
        foodItems = newList
        notifyDataSetChanged()
    }
}
