package com.example.uvenco_test_task.data.repository

import com.example.uvenco_test_task.data.storage.api.SettingsStorage
import com.example.uvenco_test_task.domain.api.MainRepository
import com.example.uvenco_test_task.domain.models.Drink
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(private val storage: SettingsStorage) : MainRepository {
    override suspend fun getTime(): Flow<String> = flow {
        emit(storage.getTime())
    }

    override suspend fun getTemperature(): Flow<String> = flow {
        emit(storage.getTemperature())
    }

    override fun getListDrinks(): List<Drink> {
        val settings = storage.getSettings()
        val drink = Drink(
            iconId = settings.iconId,
            drinkName = settings.drinkName,
            drinkPrice = settings.price
        )
        return List(15) { drink }
    }
}