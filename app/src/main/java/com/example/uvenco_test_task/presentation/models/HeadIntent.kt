package com.example.uvenco_test_task.presentation.models

sealed interface HeadIntent {
    data object RequestData : HeadIntent
}