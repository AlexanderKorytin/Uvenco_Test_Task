package com.example.uvenco_test_task.domain.api

import com.example.uvenco_test_task.domain.models.Drink

interface MainInteractor {
    fun getListDrinks(): List<Drink>
}