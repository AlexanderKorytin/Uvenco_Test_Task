package com.example.uvenco_test_task.presentation.models

import com.example.uvenco_test_task.domain.models.Settings

sealed interface SettingsScreenState {
    data object Start : SettingsScreenState
    data class Content(val settings: Settings) : SettingsScreenState
}