package com.example.uvenco_test_task.presentation.models

import com.example.uvenco_test_task.domain.models.Drink

sealed interface MainScreenState {
    data object Start: MainScreenState
    data class Content(
        val listDrinks: List<Drink>
        ): MainScreenState
}