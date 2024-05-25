package com.example.uvenco_test_task.domain.models

data class Drink(
    val iconId: IconId,
    val drinkName: String,
    val drinkPrice: Double,
    val isFree: Boolean
)