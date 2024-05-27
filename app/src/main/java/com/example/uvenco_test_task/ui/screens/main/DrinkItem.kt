package com.example.uvenco_test_task.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.uvenco_test_task.R
import com.example.uvenco_test_task.domain.models.Drink
import com.example.uvenco_test_task.domain.models.IconId
import com.example.uvenco_test_task.ui.theme.IconCupGradientEnd
import com.example.uvenco_test_task.ui.theme.IconCupGradientStart
import com.example.uvenco_test_task.ui.theme.MontserratFamily
import com.example.uvenco_test_task.ui.theme.NameTextColor
import com.example.uvenco_test_task.ui.theme.Orange
import com.example.uvenco_test_task.ui.theme.PriceGradientCentre
import com.example.uvenco_test_task.ui.theme.PriceGradientEnd
import com.example.uvenco_test_task.ui.theme.PriceGradientStart
import com.example.uvenco_test_task.ui.theme.VolumeCupColor

private val verticalGradientBrush = Brush.verticalGradient(
    colors = listOf(
        IconCupGradientStart,
        IconCupGradientEnd
    )
)
private val horizontalGradientBrush = Brush.horizontalGradient(
    colors = listOf(
        PriceGradientStart,
        PriceGradientCentre,
        PriceGradientEnd
    )
)
val drinkItemModifier = Modifier
    .padding(12.dp)
    .fillMaxSize()
    .background(brush = verticalGradientBrush, shape = RoundedCornerShape(6.dp))

private val drinkIconModifier = Modifier
    .padding(top = 24.dp, start = 30.dp, end = 30.dp)
    .size(166.dp)

private val drinkNameModifier = Modifier
    .fillMaxWidth()
    .wrapContentHeight()
    .padding(top = 12.dp, start = 30.dp, end = 30.dp, bottom = 20.dp)

private val drinkDescriptionModifier = Modifier
    .fillMaxWidth()
    .wrapContentHeight()
    .padding(top = 18.dp)
    .background(
        brush = horizontalGradientBrush,
        shape = RoundedCornerShape(bottomStart = 6.dp, bottomEnd = 6.dp)
    )
    .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)

@Composable
fun DrinkItem(drink: Drink, drinkItemModifier: Modifier) {
    Column(
        modifier = drinkItemModifier,
    ) {
        DrinkIcon(drink = drink, drinkIconModifier = drinkIconModifier)
        DrinkName(drink = drink, drinkNameModifier = drinkNameModifier)
        DrinkDescription(drink = drink, drinkDescriptionModifier = drinkDescriptionModifier)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun DrinkIcon(drink: Drink, drinkIconModifier: Modifier) {
    GlideImage(
        model = getIconCup(drink.iconId),
        contentDescription = "",
        modifier = drinkIconModifier,
        contentScale = ContentScale.Crop,
    )
}

@Composable
private fun DrinkName(drink: Drink, drinkNameModifier: Modifier) {
    Text(
        text = drink.drinkName,
        modifier = drinkNameModifier,
        color = NameTextColor,
        fontSize = 17.sp,
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun DrinkDescription(drink: Drink, drinkDescriptionModifier: Modifier) {
    val isDrinkFree = drink.isFree
    Row(
        modifier = drinkDescriptionModifier,
        horizontalArrangement = if (!isDrinkFree) Arrangement.SpaceBetween else Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.cup_size),
            color = VolumeCupColor,
            fontSize = 16.sp,
            fontFamily = MontserratFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
        if (!isDrinkFree) {
            Text(
                text = getDrinkPrice(drink.drinkPrice),
                color = Orange,
                fontSize = 18.sp,
                fontFamily = MontserratFamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }
}

fun getIconCup(id: IconId): Int {
    return when (id) {
        IconId.CAPPUCCINO -> {
            R.drawable.ic_cappuccino
        }

        IconId.MOKKACHINO -> {
            R.drawable.ic_mokkachino
        }
    }
}

private fun getDrinkPrice(price: Double): String {
    return if (price <= 0) {
        EMPTY_STR
    } else {
        "${price.toInt()} ₽"
    }
}

private const val EMPTY_STR = ""