package com.example.uvenco_test_task.domain.impl

import com.example.uvenco_test_task.domain.api.SettingsInteractor
import com.example.uvenco_test_task.domain.api.SettingsRepository
import com.example.uvenco_test_task.domain.models.Settings
import kotlinx.coroutines.flow.Flow

class SettingsInteractorImpl(private val settingsRepository: SettingsRepository) :
    SettingsInteractor {
    override suspend fun getTime(): Flow<String> {
        return settingsRepository.getTime()
    }

    override suspend fun getTemperature(): Flow<String> {
        return settingsRepository.getTemperature()
    }

    override fun getSettings(): Settings {
        return settingsRepository.getSettings()
    }

    override fun setString(settings: Settings) {
        settingsRepository.setString(settings)
    }
}