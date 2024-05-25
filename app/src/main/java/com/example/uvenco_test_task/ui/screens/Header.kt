package com.example.uvenco_test_task.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.uvenco_test_task.R
import com.example.uvenco_test_task.presentation.models.HeadIntent
import com.example.uvenco_test_task.presentation.models.HeadScreenState
import com.example.uvenco_test_task.presentation.viewmodels.HeadViewModel
import com.example.uvenco_test_task.ui.theme.AppBackground
import com.example.uvenco_test_task.ui.theme.HeadingColor
import com.example.uvenco_test_task.ui.theme.LabelColor
import com.example.uvenco_test_task.ui.theme.MontserratFamily
import org.koin.androidx.compose.koinViewModel


@Composable
fun ScreenHeader(headViewModel: HeadViewModel = koinViewModel(), onClick: () -> Unit) {
    headViewModel.updateScreen(HeadIntent.RequestData)
    when (val state = headViewModel.headScreenState.value) {
        is HeadScreenState.Content -> {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(color = AppBackground)
                    .padding(start = 24.dp, end = 50.dp, top = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Label {
                    onClick()
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.size(width = 259.dp, height = 22.dp)
                ) {
                    Time(time = state.time)
                    Temp(temperature = state.temperature)
                    Language()
                }
            }
        }

        HeadScreenState.Start -> {}
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun Label(onClick: () -> Unit) {
    Row(Modifier.clickable { onClick() }
    ) {
        GlideImage(
            model = R.drawable.ic_icon,
            contentDescription = "",
            modifier = Modifier.size(24.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
        )
        Text(
            text = stringResource(id = R.string.label_text),
            modifier = Modifier
                .padding(start = 12.dp),
            color = LabelColor,
            fontSize = 16.sp,
            fontFamily = MontserratFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun Time(time: String) {
    Text(
        text = time,
        //  modifier = Modifier.padding(start = 24.dp, end = 24.dp),
        color = HeadingColor,
        fontSize = 16.sp,
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun Temp(temperature: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        //    modifier = Modifier.padding(start = 24.dp, end = 24.dp)
    ) {
        Text(
            text = temperature,
            color = HeadingColor,
            fontSize = 16.sp,
            fontFamily = MontserratFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
        GlideImage(
            model = R.drawable.ic_drop,
            contentDescription = "",
            modifier = Modifier.size(height = 12.dp, width = 10.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun Language() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        //       modifier = Modifier.padding(start = 24.dp, end = 24.dp)
    ) {
        GlideImage(
            model = R.drawable.ic_rus_flag,
            contentDescription = "",
            modifier = Modifier.size(8.dp),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
        )
        Text(
            text = stringResource(id = R.string.ru),
            color = HeadingColor,
            fontSize = 16.sp,
            fontFamily = MontserratFamily,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}