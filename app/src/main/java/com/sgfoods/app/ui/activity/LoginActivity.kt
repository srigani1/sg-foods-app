package com.sgfoods.app.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sgfoods.app.R
import com.sgfoods.app.data.SharedPrefsHelper

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPrefsHelper: SharedPrefsHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPrefsHelper = SharedPrefsHelper(this)

        if (sharedPrefsHelper.isLoggedIn()) {
            navigateToHome()
        }

        val mobileInput = findViewById<EditText>(R.id.mobile_input)
        val loginButton = findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener {
            val mobile = mobileInput.text.toString().trim()

            if (mobile.isEmpty()) {
                Toast.makeText(this, "Please enter mobile number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (mobile.length != 10 || !mobile.all { it.isDigit() }) {
                Toast.makeText(this, "Please enter valid 10-digit mobile number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            sharedPrefsHelper.saveMobileNumber(mobile)
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
