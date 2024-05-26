package com.example.uvenco_test_task.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DrinkItem(drink: Drink) {
    val verticalGradientBrush = Brush.verticalGradient(
        colors = listOf(
            IconCupGradientStart,
            IconCupGradientEnd
        )
    )
    val horizontalGradientBrush = Brush.horizontalGradient(
        colors = listOf(
            PriceGradientStart,
            PriceGradientCentre,
            PriceGradientEnd
        )
    )
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
            .background(brush = verticalGradientBrush)
    ) {
        DrinkIcon(drink = drink)
        DrinkName(drink = drink)
        DrinkDescription(drink = drink, brush = horizontalGradientBrush)
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun DrinkIcon(drink: Drink) {
    GlideImage(
        model = getIconCup(drink.iconId),
        contentDescription = "",
        modifier = Modifier
            .padding(top = 24.dp, start = 30.dp, end = 30.dp, bottom = 6.dp)
            .size(166.dp),
        contentScale = ContentScale.Crop,
    )
}

@Composable
private fun DrinkName(drink: Drink) {
    Text(
        text = drink.drinkName,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 20.dp, start = 30.dp, end = 30.dp, bottom = 20.dp),
        color = NameTextColor,
        fontSize = 17.sp,
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun DrinkDescription(drink: Drink, brush: Brush) {
    val isDrinkFree = drink.isFree
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(brush = brush)
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
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
                textAlign = TextAlign.Center
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
    return if (price <= 0) EMPTY_STR else String.format("%.1f ₽", price)
}

private const val EMPTY_STR = ""