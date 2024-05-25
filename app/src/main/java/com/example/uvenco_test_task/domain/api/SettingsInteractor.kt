package com.example.uvenco_test_task.domain.api

import com.example.uvenco_test_task.domain.models.Settings

interface SettingsInteractor {
    fun getSettings(): Settings

    fun setString(settings: Settings)

    fun getDefaultSettings(): Settings
}