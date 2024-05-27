package com.example.uvenco_test_task.domain.api

import kotlinx.coroutines.flow.Flow

interface HeadInteractor {
    suspend fun getTime(): Flow<String>
    suspend fun getTemperature(): Flow<String>
}