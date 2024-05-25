package com.example.uvenco_test_task.presentation.models

sealed interface SettingsIntent {
    data object RequestData: SettingsIntent
}