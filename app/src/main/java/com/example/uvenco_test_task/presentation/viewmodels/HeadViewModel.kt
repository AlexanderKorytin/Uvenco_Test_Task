package com.example.uvenco_test_task.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uvenco_test_task.domain.api.HeadInteractor
import com.example.uvenco_test_task.presentation.models.HeadIntent
import com.example.uvenco_test_task.presentation.models.HeadScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeadViewModel(private val headInteractor: HeadInteractor) : ViewModel() {
    private var _headScreenState: MutableState<HeadScreenState> =
        mutableStateOf(HeadScreenState.Start)
    val headScreenState = _headScreenState
    private var jobGetDataScreen: Job? = null

    fun updateScreen(headIntent: HeadIntent) {
        when (headIntent) {
            is HeadIntent.RequestData -> {
                if (jobGetDataScreen == null) {
                    getDataScreen()
                }
            }
        }
    }

    private fun getDataScreen() {
        jobGetDataScreen = viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                headInteractor.getTime().collect { time ->
                    val temp = headInteractor.getTemperature().collect { temp ->
                        withContext(Dispatchers.Main) {
                            _headScreenState.value =
                                HeadScreenState.Content(time = time, temperature = temp)
                        }
                    }
                }
                delay(REQUEST_INTERVAL)
            }
        }
    }

}

private const val REQUEST_INTERVAL = 1000L