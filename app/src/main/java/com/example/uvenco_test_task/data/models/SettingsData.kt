package com.example.uvenco_test_task.data.models

import com.example.uvenco_test_task.domain.models.IconId
import com.example.uvenco_test_task.domain.models.Settings

data class SettingsData(
    val iconId: IconId = IconId.CAPPUCCINO,
    val drinkName: String = DEFAULT_NAME,
    val price: String = DEFAULT_PRICE,
    val isFree: Boolean = false
)

fun map(settingsData: SettingsData): Settings {
    return Settings(
        iconId = settingsData.iconId,
        drinkName = settingsData.drinkName,
        price = settingsData.price.toDouble(),
        isFree = if (settingsData.price.toDouble() <= ZERO_PRICE) true else settingsData.isFree
    )
}

fun map(settings: Settings): SettingsData {
    return SettingsData(
        iconId = settings.iconId,
        drinkName = settings.drinkName,
        price = String.format("%.1f", settings.price),
        isFree = settings.isFree,
    )
}

private const val DEFAULT_NAME = "Капучино"
private const val DEFAULT_PRICE = "199"
private const val ZERO_PRICE = 0.0