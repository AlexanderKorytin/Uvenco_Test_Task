package com.example.uvenco_test_task.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.uvenco_test_task.R
import com.example.uvenco_test_task.domain.models.IconId


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CupItem(iconId: IconId, onClick: () -> Unit, isChecked: Boolean) {
    Box(modifier = Modifier
        .wrapContentSize()
        .clickable {
            onClick()
        }
    ) {
        GlideImage(
            model = getIconCup(iconId),
            contentDescription = "",
            modifier = Modifier
                .size(300.dp)
                .align(if (iconId == IconId.CAPPUCCINO) Alignment.Center else Alignment.TopStart),
            contentScale = ContentScale.FillBounds,
        )
        if (isChecked) {
            GlideImage(
                model = R.drawable.ic_check_mark,
                contentDescription = "1",
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.BottomCenter),
                contentScale = ContentScale.Crop,
            )
        }
    }
}