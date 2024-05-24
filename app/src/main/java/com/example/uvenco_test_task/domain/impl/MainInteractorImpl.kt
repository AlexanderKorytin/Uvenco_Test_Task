package com.example.uvenco_test_task.domain.impl

import com.example.uvenco_test_task.domain.api.MainInteractor
import com.example.uvenco_test_task.domain.api.MainRepository
import com.example.uvenco_test_task.domain.models.Drink
import kotlinx.coroutines.flow.Flow

class MainInteractorImpl(private val mainRepository: MainRepository) : MainInteractor {
    override suspend fun getTime(): Flow<String> {
        return mainRepository.getTime()
    }

    override suspend fun getTemperature(): Flow<String> {
        return mainRepository.getTemperature()
    }

    override fun getListDrinks(): List<Drink> {
        return mainRepository.getListDrinks()
    }
}