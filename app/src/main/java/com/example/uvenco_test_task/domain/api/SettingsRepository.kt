package com.example.uvenco_test_task.domain.api

import com.example.uvenco_test_task.domain.models.Settings
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun getTime(): Flow<String>

    suspend fun getTemperature(): Flow<String>

    fun getSettings(): Settings

    fun setString(settings: Settings)
}