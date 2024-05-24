package com.example.uvenco_test_task.data.repository

import com.example.uvenco_test_task.data.models.map
import com.example.uvenco_test_task.data.storage.api.SettingsStorage
import com.example.uvenco_test_task.domain.api.SettingsRepository
import com.example.uvenco_test_task.domain.models.Settings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SettingsRepositoryImpl(private val storage: SettingsStorage) : SettingsRepository {
    override suspend fun getTime(): Flow<String> = flow {
        emit(storage.getTime())
    }

    override suspend fun getTemperature(): Flow<String> = flow {
        emit(storage.getTemperature())
    }

    override fun getSettings(): Settings {
        return map(storage.getSettings())
    }

    override fun setString(settings: Settings) {
        storage.setString(map(settings))
    }

}