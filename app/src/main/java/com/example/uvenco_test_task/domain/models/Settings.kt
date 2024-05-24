package com.example.uvenco_test_task.domain.models

data class Settings(
    val iconId: IconId,
    val drinkName: String,
    val price: String,
    val checkMarkList: List<Boolean>
)
