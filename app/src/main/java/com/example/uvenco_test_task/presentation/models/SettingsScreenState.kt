package com.example.uvenco_test_task.presentation.models

import com.example.uvenco_test_task.domain.models.IconId

sealed interface SettingsScreenState {
    data object Start: SettingsScreenState

    data class Content(
        val drinkName: String,
        val drinkPrise: String,
        val drinkIsFree: Boolean,
        val checkMarkList: List<Boolean>,
        val isSettingsChanged: Boolean
    ): SettingsScreenState
}