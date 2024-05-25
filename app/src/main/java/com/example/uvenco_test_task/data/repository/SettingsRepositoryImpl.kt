package com.example.uvenco_test_task.data.repository

import com.example.uvenco_test_task.data.models.SettingsData
import com.example.uvenco_test_task.data.models.map
import com.example.uvenco_test_task.data.storage.api.SettingsStorage
import com.example.uvenco_test_task.domain.api.SettingsRepository
import com.example.uvenco_test_task.domain.models.Settings

class SettingsRepositoryImpl(private val storage: SettingsStorage) : SettingsRepository {
    override fun getSettings(): Settings {
        return map(storage.getSettings())
    }

    override fun setString(settings: Settings) {
        storage.setString(map(settings))
    }

    override fun getDefaultSettings(): Settings {
        return map(SettingsData())
    }
}