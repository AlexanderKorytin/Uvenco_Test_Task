package com.example.uvenco_test_task.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uvenco_test_task.domain.models.Drink
import com.example.uvenco_test_task.presentation.models.MainIntent
import com.example.uvenco_test_task.presentation.models.MainScreenState
import com.example.uvenco_test_task.presentation.viewmodels.MainViewModel
import com.example.uvenco_test_task.ui.theme.AppBackground
import com.example.uvenco_test_task.ui.theme.IconCupGradientStart
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun MainScreen(mainViewModel: MainViewModel = koinViewModel()) {
    mainViewModel.updateScreen(MainIntent.RequestData)
    when (val state = mainViewModel.mainScreenState.value) {
        is MainScreenState.Content -> {
            Column {
                ScreenHeader {

                }
                Divider(color = IconCupGradientStart, thickness = 1.dp)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(QUANITY_COLUMS),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = AppBackground)
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    items(state.listDrinks) { item: Drink ->
                        DrinkItem(item)
                    }
                }
            }
        }

        MainScreenState.Start -> {}
    }
}

private const val QUANITY_COLUMS = 5