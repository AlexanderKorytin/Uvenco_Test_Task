package com.example.uvenco_test_task.data.models

import com.example.uvenco_test_task.domain.models.IconId
import com.example.uvenco_test_task.domain.models.Settings

data class SettingsData(
    val iconId: IconId = IconId.CAPPUCCINO,
    val drinkName: String = DEFAULT_NAME,
    val price: String = DEFAULT_PRICE
)

fun map(settingsData: SettingsData): Settings {
    return Settings(
        iconId = settingsData.iconId,
        drinkName = settingsData.drinkName,
        price = settingsData.price,
        checkMarkList = getCheckMarkList(settingsData.iconId)
    )
}

fun map(settings: Settings): SettingsData {
    return SettingsData(
        iconId = settings.iconId,
        drinkName = settings.drinkName,
        price = settings.price
    )
}

private fun getCheckMarkList(iconId: IconId): List<Boolean> {
    return listOf(iconId == IconId.CAPPUCCINO, iconId == IconId.MOKKACHINO)
}

private const val DEFAULT_NAME = "Капучино"
private const val DEFAULT_PRICE = "0"