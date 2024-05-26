package com.example.uvenco_test_task

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.ui.UiComposable
import androidx.compose.ui.unit.dp
import com.example.uvenco_test_task.ui.screens.ScreenHeader
import com.example.uvenco_test_task.ui.screens.SettingsScreen
import com.example.uvenco_test_task.ui.theme.IconCupGradientStart

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                ScreenHeader {

                }
                Divider(color = IconCupGradientStart, thickness = 1.dp)
                SettingsScreen()
            }
        }
    }
}