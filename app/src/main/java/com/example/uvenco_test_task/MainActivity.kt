package com.example.uvenco_test_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.uvenco_test_task.presentation.models.MainIntent
import com.example.uvenco_test_task.presentation.models.MainScreenState
import com.example.uvenco_test_task.presentation.viewmodels.MainViewModel
import com.example.uvenco_test_task.ui.theme.AppBackground
import com.example.uvenco_test_task.ui.theme.NameTextColor
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
   // private val mainViewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // mainViewModel.updateScreen(MainIntent.RequestData)
        setContent {
            MainScreen()
        }
    }
}

@Composable
internal fun MainScreen(mainViewModel: MainViewModel = koinViewModel()) {
    mainViewModel.updateScreen(MainIntent.RequestData)
    when (val state = mainViewModel.mainScreenState.value) {
        is MainScreenState.Content -> {
            Box(
                modifier = Modifier
                    .background(color = AppBackground)
                    .fillMaxSize()
            ) {
                Text(
                    text = state.temperature,
                    fontSize = 64.sp,
                    modifier = Modifier.align(Alignment.Center),
                    color = NameTextColor
                )
            }
        }

        MainScreenState.Start -> {}
    }
}