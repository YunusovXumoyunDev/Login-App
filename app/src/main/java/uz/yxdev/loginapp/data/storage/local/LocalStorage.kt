package uz.yxdev.loginapp.data.storage.local

import android.content.Context

class LocalStorage(private val context: Context) {
private val pref=context.getSharedPreferences("my_app_local_storage", Context.MODE_PRIVATE)
    fun saveString(key: String, value: String) {
        pref.edit().apply {
            putString(key, value)
            apply()
        }
    }

    fun saveBoolean(key: String, value: Boolean) {
        pref.edit().apply {
            putBoolean(key, value)
            apply()
        }
    }


    fun getString(key: String): String {
        return pref.getString(key, "") ?: ""
    }

    fun getBoolean(key: String): Boolean {
        return pref.getBoolean(key, false)
    }
}