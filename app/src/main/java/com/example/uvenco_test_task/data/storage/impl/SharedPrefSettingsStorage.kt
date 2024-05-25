package com.example.uvenco_test_task.data.storage.impl

import android.content.SharedPreferences
import android.icu.text.SimpleDateFormat
import com.example.uvenco_test_task.data.models.SettingsData
import com.example.uvenco_test_task.data.storage.api.SettingsStorage
import com.google.gson.Gson
import java.util.Calendar
import java.util.Locale
import kotlin.random.Random

class SharedPrefSettingsStorage(
    private val sharedPreferences: SharedPreferences, private val json: Gson
) : SettingsStorage {

    override fun getSettings(): SettingsData {
        val settingsStr = sharedPreferences.getString(SETTINGS, EMPTY_SETTINGS)
        return if (settingsStr == EMPTY_SETTINGS) {
            SettingsData()
        } else {
            json.fromJson(settingsStr, SettingsData::class.java)
        }
    }

    override fun setString(settingsData: SettingsData) {
        sharedPreferences.edit().putString(SETTINGS, json.toJson(settingsData)).apply()
    }
}

private const val SETTINGS = "settings"
private const val EMPTY_SETTINGS = "-1"