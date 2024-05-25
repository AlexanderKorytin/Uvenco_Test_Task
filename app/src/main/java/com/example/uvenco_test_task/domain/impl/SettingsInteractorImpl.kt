package com.example.uvenco_test_task.domain.impl

import com.example.uvenco_test_task.domain.api.SettingsInteractor
import com.example.uvenco_test_task.domain.api.SettingsRepository
import com.example.uvenco_test_task.domain.models.Settings

class SettingsInteractorImpl(private val settingsRepository: SettingsRepository) :
    SettingsInteractor {
    override fun getSettings(): Settings {
        return settingsRepository.getSettings()
    }

    override fun setString(settings: Settings) {
        settingsRepository.setString(settings)
    }

    override fun getDefaultSettings(): Settings {
        return settingsRepository.getDefaultSettings()
    }
}