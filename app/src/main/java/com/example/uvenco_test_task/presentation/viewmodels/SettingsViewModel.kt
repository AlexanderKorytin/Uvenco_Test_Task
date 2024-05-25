package com.example.uvenco_test_task.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.uvenco_test_task.domain.api.SettingsInteractor
import com.example.uvenco_test_task.domain.models.Settings
import com.example.uvenco_test_task.presentation.models.SettingsIntent
import com.example.uvenco_test_task.presentation.models.SettingsScreenState

class SettingsViewModel(private val settingsInteractor: SettingsInteractor) : ViewModel() {
    private var _savedSettings: Settings = settingsInteractor.getDefaultSettings()
    private var _settingsScreenState: MutableState<SettingsScreenState> =
        mutableStateOf(SettingsScreenState.Start)
    val settingsScreenState: State<SettingsScreenState> = _settingsScreenState

    fun updateScreen(settingsIntent: SettingsIntent) {
        when (settingsIntent) {
            is SettingsIntent.RequestData -> {
                getDataScreen()
            }
        }
    }

    private fun getDataScreen() {
        _savedSettings = settingsInteractor.getSettings()
        val isChanged = compareSettings(_savedSettings)
        _settingsScreenState.value = SettingsScreenState.Content(
            drinkName = _savedSettings.drinkName,
            drinkPrise = _savedSettings.price.toString(),
            drinkIsFree = _savedSettings.isFree,
            checkMarkList = _savedSettings.checkMarkList,
            isSettingsChanged = isChanged
        )
    }

    private fun compareSettings(newSettings: Settings): Boolean {
        return (
                _savedSettings.checkMarkList == newSettings.checkMarkList &&
                        _savedSettings.isFree == newSettings.isFree &&
                        _savedSettings.drinkName == newSettings.drinkName &&
                        _savedSettings.price == newSettings.price

                )
    }
}