package com.sgfoods.app.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sgfoods.app.R
import com.sgfoods.app.ui.adapter.PaymentMethodAdapter

class PaymentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payments)

        val backButton = findViewById<ImageView>(R.id.back_button)
        val paymentMethodsRecyclerView = findViewById<RecyclerView>(R.id.payment_methods_recycler_view)
        val addCardButton = findViewById<Button>(R.id.add_card_button)
        val addMoneyButton = findViewById<Button>(R.id.add_money_button)

        backButton.setOnClickListener {
            finish()
        }

        val paymentMethods = listOf(
            "Debit Card - XXXX XXXX XXXX 1234",
            "Credit Card - XXXX XXXX XXXX 5678",
            "UPI - user@bank",
            "Wallet Balance - Rs 500"
        )

        val adapter = PaymentMethodAdapter(paymentMethods)
        paymentMethodsRecyclerView.layoutManager = LinearLayoutManager(this)
        paymentMethodsRecyclerView.adapter = adapter

        addCardButton.setOnClickListener {
            Toast.makeText(this, "Add new card functionality", Toast.LENGTH_SHORT).show()
        }

        addMoneyButton.setOnClickListener {
            Toast.makeText(this, "Add money to wallet functionality", Toast.LENGTH_SHORT).show()
        }
    }
}
