package com.example.uvenco_test_task.presentation.models

import com.example.uvenco_test_task.domain.models.Settings

sealed interface SettingsIntent {
    data object RequestData : SettingsIntent
    data class SetNewData(val newData: Settings) : SettingsIntent
    data object SaveData : SettingsIntent
}