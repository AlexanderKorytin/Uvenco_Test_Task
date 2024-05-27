package com.example.uvenco_test_task.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uvenco_test_task.domain.models.Drink
import com.example.uvenco_test_task.presentation.models.MainIntent
import com.example.uvenco_test_task.presentation.models.MainScreenState
import com.example.uvenco_test_task.presentation.viewmodels.MainViewModel
import com.example.uvenco_test_task.ui.theme.AppBackground
import org.koin.androidx.compose.koinViewModel

private val containerScreenModifier = Modifier
    .fillMaxSize()
    .background(color = AppBackground)
    .padding(12.dp)

@Composable
internal fun MainScreen(mainViewModel: MainViewModel = koinViewModel()) {
    SideEffect {
        mainViewModel.updateScreen(MainIntent.RequestData)
    }
    when (val state = mainViewModel.mainScreenState.value) {
        is MainScreenState.Content -> {
            Column {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(QUANITY_COLUMS),
                    modifier = containerScreenModifier,
                    horizontalArrangement = Arrangement.Center
                ) {
                    items(state.listDrinks) { item: Drink ->
                        DrinkItem(item, drinkItemModifier)
                    }
                }
            }
        }

        MainScreenState.Start -> {}
    }
}

private const val QUANITY_COLUMS = 5