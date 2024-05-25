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
        checkMarkList = getCheckMarkList(settingsData.iconId),
        isFree = settingsData.isFree && settingsData.price.toDouble() <= ZERO_PRICE
    )
}

fun map(settings: Settings): SettingsData {
    return SettingsData(
        iconId = settings.iconId,
        drinkName = settings.drinkName,
        price = String.format("%1.f", settings.price)
    )
}

private fun getCheckMarkList(iconId: IconId): List<Boolean> {
    return listOf(iconId == IconId.CAPPUCCINO, iconId == IconId.MOKKACHINO)
}

private const val DEFAULT_NAME = "Капучино"
private const val DEFAULT_PRICE = "199"
private const val ZERO_PRICE = 0f