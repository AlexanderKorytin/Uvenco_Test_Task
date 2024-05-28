package com.example.uvenco_test_task.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.uvenco_test_task.ui.screens.ScreenHeader
import com.example.uvenco_test_task.ui.screens.settings.SettingsScreen
import com.example.uvenco_test_task.ui.theme.IconCupGradientStart

fun NavGraphBuilder.settings(onLabelClick: () -> Unit) {
    composable(route = ROOT_SETTINGS) {
        Column {
            ScreenHeader(onClick = onLabelClick)
            Divider(color = IconCupGradientStart, thickness = 1.dp)
            SettingsScreen()
        }
    }

}