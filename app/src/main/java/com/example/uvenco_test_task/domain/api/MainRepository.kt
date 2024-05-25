package com.example.uvenco_test_task.domain.api

import com.example.uvenco_test_task.domain.models.Drink
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getListDrinks(): List<Drink>
}