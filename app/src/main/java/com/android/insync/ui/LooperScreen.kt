package com.android.insync.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.insync.ui.components.LoopPad
import com.android.insync.ui.components.LoopPadState
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
        Column {
            Text(
                text = "Looper Screen",
            )

            LoopPadGrid()
        }
    }
}

@Composable
fun LoopPadGrid(
    loopStates : Array<LoopPadState> = arrayOf(LoopPadState.Playing, LoopPadState.Stopped, LoopPadState.Recording, LoopPadState.Stopped)
) {
    val columns: Int = 2

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        userScrollEnabled = true,
    ) {
        itemsIndexed(loopStates) { index, item ->
            LoopPad(
                modifier = Modifier.size(250.dp),
                loopPadState = item,
                onClick = {
                    //viewModel.onLoopPadClick(index)
                }
            )
        }
    }
}

@Preview
@Composable
fun LooperScreenPreview() {
    LooperScreen()
}