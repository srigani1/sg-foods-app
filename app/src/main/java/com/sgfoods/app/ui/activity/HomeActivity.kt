package com.sgfoods.app.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sgfoods.app.R
import com.sgfoods.app.data.FoodRepository
import com.sgfoods.app.data.SharedPrefsHelper
import com.sgfoods.app.ui.adapter.FoodAdapter

class HomeActivity : AppCompatActivity() {
    private lateinit var sharedPrefsHelper: SharedPrefsHelper
    private lateinit var foodAdapter: FoodAdapter
    private var allFoodItems = FoodRepository.getFoodItems()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sharedPrefsHelper = SharedPrefsHelper(this)

        val searchInput = findViewById<EditText>(R.id.search_input)
        val foodRecyclerView = findViewById<RecyclerView>(R.id.food_recycler_view)
        val profileIcon = findViewById<ImageView>(R.id.profile_icon)
        val paymentIcon = findViewById<ImageView>(R.id.payment_icon)

        foodAdapter = FoodAdapter(allFoodItems)
        foodRecyclerView.layoutManager = GridLayoutManager(this, 2)
        foodRecyclerView.adapter = foodAdapter

        searchInput.setOnEditorActionListener { _, _, _ ->
            val query = searchInput.text.toString()
            filterFood(query)
            false
        }

        profileIcon.setOnClickListener {
            showProfileDialog()
        }

        paymentIcon.setOnClickListener {
            val intent = Intent(this, PaymentsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun filterFood(query: String) {
        val filteredList = if (query.isEmpty()) {
            allFoodItems
        } else {
            allFoodItems.filter {
                it.name.contains(query, ignoreCase = true) || it.category.contains(query, ignoreCase = true)
            }
        }
        foodAdapter.updateList(filteredList)
    }

    private fun showProfileDialog() {
        val options = arrayOf("My Orders", "Favorites", "My Addresses", "Settings", "Help & Support", "Sign Out")
        AlertDialog.Builder(this)
            .setTitle("Profile Options")
            .setItems(options) { _, which ->
                when (which) {
                    5 -> signOut()
                }
            }
            .show()
    }

    private fun signOut() {
        sharedPrefsHelper.clearAll()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
