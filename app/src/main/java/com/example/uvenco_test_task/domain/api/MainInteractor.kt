package com.example.uvenco_test_task.domain.api

import com.example.uvenco_test_task.domain.models.Drink
import kotlinx.coroutines.flow.Flow

interface MainInteractor {
    suspend fun getTime(): Flow<String>

    suspend fun getTemperature(): Flow<String>

    fun getListDrinks(): List<Drink>
}