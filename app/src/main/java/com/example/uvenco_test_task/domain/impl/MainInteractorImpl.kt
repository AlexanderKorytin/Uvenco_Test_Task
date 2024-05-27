package com.example.uvenco_test_task.domain.impl

import com.example.uvenco_test_task.domain.api.MainInteractor
import com.example.uvenco_test_task.domain.api.MainRepository
import com.example.uvenco_test_task.domain.models.Drink

class MainInteractorImpl(private val mainRepository: MainRepository) : MainInteractor {
    override fun getListDrinks(): List<Drink> {
        return mainRepository.getListDrinks()
    }
}