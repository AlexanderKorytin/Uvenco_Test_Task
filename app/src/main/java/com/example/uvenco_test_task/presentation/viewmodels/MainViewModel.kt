package com.example.uvenco_test_task.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.uvenco_test_task.domain.api.MainInteractor
import com.example.uvenco_test_task.presentation.models.MainIntent
import com.example.uvenco_test_task.presentation.models.MainScreenState
import kotlinx.coroutines.Job

class MainViewModel(private val mainInteractor: MainInteractor) : ViewModel() {
    private var _mainScreenState: MutableState<MainScreenState> =
        mutableStateOf(MainScreenState.Start)
    val mainScreenState = _mainScreenState
    private var jobGetDataScreen: Job? = null

    fun updateScreen(mainIntent: MainIntent) {
        when (mainIntent) {
            is MainIntent.RequestData -> {
                getDataScreen()
            }
        }
    }

    private fun getDataScreen() {
        val list = mainInteractor.getListDrinks()
        _mainScreenState.value = MainScreenState.Content(listDrinks = list)
    }

}

private const val REQUEST_INTERVAL = 1000L