package com.android.insync.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.insync.R


enum class LoopPadState {
    Playing,
    Stopped,
    Recording
}

@Composable
fun LoopPad(
    modifier: Modifier = Modifier,
    loopPadState: LoopPadState = LoopPadState.Stopped,
    onClick: () -> Unit,
) {
    FilledIconButton(
        modifier = modifier,
        onClick = onClick,
        shape = CutCornerShape(4.dp),
    ) {
        when (loopPadState) {
            LoopPadState.Playing -> {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "Play",
                )
            }

            LoopPadState.Stopped -> {
                Icon(
                    painter = painterResource(R.drawable.pause_icon),
                    modifier = Modifier.fillMaxSize(0.5f),
                    contentDescription = "Pause",
                )
            }

            LoopPadState.Recording -> {
                Icon(
                    painter = painterResource(R.drawable.record_icon),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "Record",
                )
            }
        }
    }
}


@Preview
@Composable
fun LoopPadPreview() {
    val loopPadStates = LoopPadState.entries.toTypedArray()
    var padStateIndex: Int by remember { mutableStateOf(0) }

    LoopPad(
        loopPadState = loopPadStates[padStateIndex],
        onClick = {
            padStateIndex++
            padStateIndex = (padStateIndex) % loopPadStates.size
        }
    )
}