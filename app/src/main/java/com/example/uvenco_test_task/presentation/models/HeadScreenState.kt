package com.example.uvenco_test_task.presentation.models

sealed interface HeadScreenState {
    data object Start : HeadScreenState
    data class Content(
        val time: String,
        val temperature: String
    ) : HeadScreenState
}