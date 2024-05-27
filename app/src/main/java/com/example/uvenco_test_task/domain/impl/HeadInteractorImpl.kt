package com.example.uvenco_test_task.domain.impl

import com.example.uvenco_test_task.domain.api.HeadInteractor
import com.example.uvenco_test_task.domain.api.HeadRepository
import kotlinx.coroutines.flow.Flow

class HeadInteractorImpl(private val headRepository: HeadRepository) : HeadInteractor {
    override suspend fun getTime(): Flow<String> {
        return headRepository.getTime()
    }

    override suspend fun getTemperature(): Flow<String> {
        return headRepository.getTemperature()
    }
}