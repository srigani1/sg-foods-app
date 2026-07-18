package com.sgfoods.app.data

import android.content.Context
import android.content.SharedPreferences

class SharedPrefsHelper(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("sg_foods_prefs", Context.MODE_PRIVATE)

    fun saveMobileNumber(mobile: String) {
        prefs.edit().putString("mobile_number", mobile).apply()
    }

    fun getMobileNumber(): String? {
        return prefs.getString("mobile_number", null)
    }

    fun isLoggedIn(): Boolean {
        return prefs.getString("mobile_number", null) != null
    }

    fun clearAll() {
        prefs.edit().clear().apply()
    }
}
