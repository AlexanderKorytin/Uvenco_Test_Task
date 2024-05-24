package com.example.uvenco_test_task.presentation.models

sealed interface MainIntent {
    data object RequestData: MainIntent
}