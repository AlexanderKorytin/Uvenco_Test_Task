package com.example.uvenco_test_task.presentation.viewmodels

import androidx.compose.runtime.MutableState
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
    val settingScreenState = _settingsScreenState
    private var _newSettings: Settings = settingsInteractor.getDefaultSettings()

    init {
        _savedSettings = settingsInteractor.getSettings()
        _newSettings = _savedSettings
        _settingsScreenState.value = SettingsScreenState.Content(
            _newSettings
        )
    }

    fun updateScreen(settingsIntent: SettingsIntent) {
        when (settingsIntent) {
            is SettingsIntent.RequestData -> {
                getDataScreen()
            }

            is SettingsIntent.SetNewData -> {
                setNewSettings(settingsIntent.newData)
            }

            SettingsIntent.SaveData -> {
                saveSettings()
            }
        }
    }

    private fun setNewSettings(newSettings: Settings) {
        _newSettings = newSettings
        _settingsScreenState.value = SettingsScreenState.Content(_newSettings)
    }

    private fun saveSettings() {
        settingsInteractor.setString(_newSettings)
        _settingsScreenState.value = SettingsScreenState.Content(_savedSettings)
        _savedSettings = _newSettings
        _settingsScreenState.value = SettingsScreenState.Content(_newSettings)
    }

    private fun getDataScreen() {
        _settingsScreenState.value = SettingsScreenState.Content(
            _newSettings
        )
    }

    fun compareSettings(): Boolean {
        return (
                _savedSettings.isFree == _newSettings.isFree &&
                        _savedSettings.drinkName == _newSettings.drinkName &&
                        _savedSettings.price == _newSettings.price &&
                        _savedSettings.iconId == _newSettings.iconId

                )
    }
}