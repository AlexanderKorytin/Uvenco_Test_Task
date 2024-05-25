package com.example.uvenco_test_task.data.storage.api

import com.example.uvenco_test_task.data.models.SettingsData
import kotlinx.coroutines.flow.Flow

interface SettingsStorage {

    fun getSettings(): SettingsData

    fun setString(settingsData: SettingsData)
}