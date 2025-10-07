package com.android.insync.ui

import android.os.Looper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.insync.viewmodel.LooperViewModel

@Composable
fun LooperScreen(
    modifier: Modifier = Modifier,
    viewModel: LooperViewModel = LooperViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Looper Screen",
        )
    }
}

@Preview
@Composable
fun LooperScreenPreview() {
    LooperScreen()
}