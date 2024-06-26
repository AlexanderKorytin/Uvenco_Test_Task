package com.example.uvenco_test_task.ui.screens.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uvenco_test_task.R
import com.example.uvenco_test_task.domain.models.IconId
import com.example.uvenco_test_task.domain.models.Settings
import com.example.uvenco_test_task.presentation.models.SettingsIntent
import com.example.uvenco_test_task.presentation.models.SettingsScreenState
import com.example.uvenco_test_task.presentation.viewmodels.SettingsViewModel
import com.example.uvenco_test_task.ui.theme.AppBackground
import com.example.uvenco_test_task.ui.theme.CheckMarkColor
import com.example.uvenco_test_task.ui.theme.EditTextBackGroundColor
import com.example.uvenco_test_task.ui.theme.EditTextTextColor
import com.example.uvenco_test_task.ui.theme.MontserratFamily
import com.example.uvenco_test_task.ui.theme.NameTextColor
import com.example.uvenco_test_task.ui.theme.Orange
import com.example.uvenco_test_task.ui.theme.RubLabelColor
import com.example.uvenco_test_task.ui.theme.SaveButtonTextColor
import org.koin.androidx.compose.koinViewModel

private val drinkNameLabelModifier = Modifier.padding(bottom = 12.dp)
private val drinkPriceLabelModifier = Modifier.padding(top = 32.dp, bottom = 12.dp)
private val screenContainerModifier =
    Modifier
        .fillMaxSize()
        .background(color = AppBackground)
        .padding(end = 30.dp)
private val spacerModifier = Modifier
    .padding(top = 64.dp)
    .size(width = 162.dp, height = 60.dp)
private val drinkNameValueModifier = Modifier
    .background(color = EditTextBackGroundColor)
    .size(width = 418.dp, height = 52.dp)
private val drinkPriceValueModifier = Modifier
    .size(width = 418.dp, height = 52.dp)

@Composable
fun SettingsScreen(settingsViewModel: SettingsViewModel = koinViewModel()) {
    SideEffect {
        settingsViewModel.updateScreen(SettingsIntent.RequestData)
    }

    val switchChecked = remember {
        mutableStateOf(false)
    }
    when (val settings = settingsViewModel.settingScreenState.value) {
        is SettingsScreenState.Content -> {
            Row(
                modifier = screenContainerModifier,
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                DrinkDescription(
                    settings = settings.settings,
                    viewModel = settingsViewModel,
                    switchChecked = switchChecked,
                )
                FieldCupChecked(settings = settings.settings, viewModel = settingsViewModel)
            }
        }

        SettingsScreenState.Start -> {

        }
    }
}

@Composable
private fun DrinkDescription(
    settings: Settings,
    viewModel: SettingsViewModel,
    switchChecked: MutableState<Boolean>,
) {
    Column {
        ChapterNameLabel(message = R.string.name, drinkNameLabelModifier = drinkNameLabelModifier)
        ChapterNameValue(
            settings = settings,
            viewModel = viewModel,
            drinkNameValueModifier = drinkNameValueModifier

        )
        ChapterPriceLabel(
            message = R.string.price,
            drinkPriceLabelModifier = drinkPriceLabelModifier
        )
        ChapterPriceValue(
            settings = settings,
            viewModel = viewModel,
            drinkPriceValueModifier = drinkPriceValueModifier
        )
        SwitchIsDrinkFree(
            settings = settings,
            viewModel = viewModel,
            switchChecked = switchChecked
        )
        if (!viewModel.compareSettings()) {
            SaveButton(viewModel)
        } else {
            Spacer(
                modifier = spacerModifier
            )
        }
    }
}

@Composable
private fun ChapterNameLabel(@StringRes message: Int, drinkNameLabelModifier: Modifier) {
    Text(
        text = stringResource(id = R.string.name),
        color = NameTextColor,
        fontSize = 16.sp,
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Start,
        modifier = drinkNameLabelModifier
    )
}

@Composable
private fun ChapterNameValue(
    settings: Settings,
    viewModel: SettingsViewModel,
    drinkNameValueModifier: Modifier
) {
    TextField(
        value = settings.drinkName,
        onValueChange = {
            val newSettings = settings.copy(drinkName = it)
            viewModel.updateScreen(SettingsIntent.SetNewData(newSettings))
        },
        singleLine = true,
        modifier = drinkNameValueModifier,
        colors = TextFieldDefaults.colors(
            focusedTextColor = EditTextTextColor,
            unfocusedTextColor = EditTextTextColor,
            focusedContainerColor = EditTextBackGroundColor,
            unfocusedContainerColor = EditTextBackGroundColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(6.dp)
    )
}

@Composable
private fun ChapterPriceLabel(@StringRes message: Int, drinkPriceLabelModifier: Modifier) {
    Text(
        text = stringResource(id = R.string.name),
        color = NameTextColor,
        fontSize = 16.sp,
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Start,
        modifier = drinkPriceLabelModifier
    )
}

@Composable
private fun ChapterPriceValue(
    settings: Settings,
    viewModel: SettingsViewModel,
    drinkPriceValueModifier: Modifier
) {
    TextField(
        value = settings.price.toInt().toString(),
        onValueChange = {
            val price = getPriceValue(value = it)
            val newSettings = getSettingsWithPrice(newPrice = price, settings = settings)
            viewModel.updateScreen(SettingsIntent.SetNewData(newSettings))
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_rub),
                contentDescription = ""
            )
        },
        modifier = drinkPriceValueModifier,
        colors = TextFieldDefaults.colors(
            focusedTextColor = EditTextTextColor,
            unfocusedTextColor = EditTextTextColor,
            focusedContainerColor = EditTextBackGroundColor,
            unfocusedContainerColor = EditTextBackGroundColor,
            focusedTrailingIconColor = RubLabelColor,
            unfocusedTrailingIconColor = RubLabelColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(6.dp),
    )
}


@Composable
private fun SwitchIsDrinkFree(
    settings: Settings,
    viewModel: SettingsViewModel,
    switchChecked: MutableState<Boolean>
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 12.dp)
            .size(width = 418.dp, height = 48.dp)
            .border(
                BorderStroke(1.dp, color = EditTextBackGroundColor),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Text(
            text = stringResource(id = R.string.sale_free),
            color = NameTextColor,
            fontSize = 16.sp,
            fontFamily = MontserratFamily,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(start = 24.dp)
        )
        Switch(
            checked = settings.isFree,
            onCheckedChange = {
                val newSettings = settings.copy(isFree = it)
                viewModel.updateScreen(SettingsIntent.SetNewData(newSettings))
                switchChecked.value = it
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = CheckMarkColor,
                uncheckedThumbColor = CheckMarkColor,
                checkedTrackColor = Orange,
                uncheckedTrackColor = Orange
            ),
            modifier = Modifier.padding(end = 24.dp, top = 12.dp, bottom = 12.dp)
        )
    }
}

@Composable
private fun SaveButton(viewModel: SettingsViewModel) {
    Button(
        onClick = {
            viewModel.updateScreen(SettingsIntent.SaveData)
        },
        modifier = Modifier
            .padding(top = 64.dp)
            .wrapContentSize(),
        contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp, start = 24.dp, end = 24.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Orange),
    ) {
        Text(
            text = stringResource(id = R.string.save),
            color = SaveButtonTextColor,
            fontSize = 20.sp,
            fontFamily = MontserratFamily,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun FieldCupChecked(settings: Settings, viewModel: SettingsViewModel) {
    val listIconIds = listOf(IconId.CAPPUCCINO, IconId.MOKKACHINO)
    LazyRow(
        modifier = Modifier.padding(end = 30.dp, bottom = 90.dp),
        verticalAlignment = Alignment.Top
    ) {
        items(listIconIds) { currentIconId ->
            CupItem(
                iconId = currentIconId,
                isChecked = settings.iconId == currentIconId,
                onClick = {
                    val newSettings = settings.copy(iconId = currentIconId)
                    viewModel.updateScreen(SettingsIntent.SetNewData(newSettings))
                },
            )
        }
    }
}

private fun getPriceValue(value: String): Double {
    val tempPrice = if (value.contains(DELIMITER)) {
        value.split(DELIMITER)[0]
    } else {
        value
    }
    val price = if (tempPrice.length > 9) {
        tempPrice.take(9).toDouble()
    } else if (tempPrice.isEmpty()) {
        ZERO
    } else {
        tempPrice.toDouble()
    }
    return price
}

private fun getSettingsWithPrice(newPrice: Double, settings: Settings): Settings {
    val newSettings =
        if (newPrice == ZERO) {
            settings.copy(price = newPrice, isFree = true)
        } else {
            settings.copy(price = newPrice)
        }
    return newSettings
}

private const val ZERO = 0.0
private const val DELIMITER = ','