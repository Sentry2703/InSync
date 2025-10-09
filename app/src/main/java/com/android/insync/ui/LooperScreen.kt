package com.android.insync.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val isRecording by viewModel.isRecording.collectAsState()
        val playingState = if (isRecording) { "Recording" } else { "Playing" }
        val recordingPads by viewModel.recordingPads.collectAsState()

        LoopPadGrid(viewModel, recordingPads)

        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Switch(
                checked = isRecording,
                onCheckedChange = { viewModel.toggleRecording() }
            )

            Text(
                text = playingState,
                fontSize = 24.sp
            )
        }

        FilledTonalButton(
            onClick = { viewModel.addPad() },
            shape = CircleShape,
            enabled = recordingPads.size < LooperViewModel.MAX_RECORDING_PADS
        ) {
            Icon(Icons.Default.Add, contentDescription = "Add")
            Text("Add Button", fontSize = 16.sp)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoopPadGrid(
    viewModel: LooperViewModel,
    loopStates : ArrayList<LoopPadState> = ArrayList<LoopPadState>(listOf(LoopPadState.Playing, LoopPadState.Stopped, LoopPadState.Recording, LoopPadState.Stopped))
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
                modifier = Modifier
                    .size(250.dp),
                loopPadState = item,
                onClick = {
                    viewModel.onLoopPadClick(index)
                },
                onLongPress = {
                    viewModel.removePad(index)
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