package com.example.uvenco_test_task.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uvenco_test_task.domain.api.MainInteractor
import com.example.uvenco_test_task.presentation.models.MainIntent
import com.example.uvenco_test_task.presentation.models.MainScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val mainInteractor: MainInteractor) : ViewModel() {
    private var _mainScreenState: MutableState<MainScreenState> = mutableStateOf(MainScreenState.Start)
    val mainScreenState = _mainScreenState

    fun updateScreen(mainIntent: MainIntent) {
        when (mainIntent) {
            is MainIntent.RequestData -> {
                getDataScreen()
            }
        }
    }

    private fun getDataScreen() {
        val list = mainInteractor.getListDrinks()
        var job: Job? = null
        while (job == null || job.isActive) {
        job = viewModelScope.launch(Dispatchers.IO) {
                mainInteractor.getTime().collect { time ->
                    val temp = mainInteractor.getTemperature().collect { temp ->
                        withContext(Dispatchers.Main) {
                            _mainScreenState.value =
                                MainScreenState.Content(
                                    temperature = temp,
                                    time = time,
                                    listDrinks = list
                                )
                        }
                    }
                }
                delay(REQUEST_INTERVAL)
            }
        }
    }
}

private const val REQUEST_INTERVAL = 1000L