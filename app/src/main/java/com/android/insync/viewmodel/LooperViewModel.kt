package com.android.insync.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.android.insync.ui.components.LoopPadState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LooperViewModel: ViewModel() {
     companion object {
         const val MAX_RECORDING_PADS = 2
     }

    private val _isRecording = MutableStateFlow(false)
    val isRecording: StateFlow<Boolean> = _isRecording.asStateFlow()

    fun toggleRecording() {
        _isRecording.value = !_isRecording.value

        _recordingPads. update { recordingPads ->
            val list = ArrayList<LoopPadState>()
            for (item in recordingPads) {
                list.add(LoopPadState.Stopped)
            }
            list
        }
    }

    private val _recordingPads: MutableStateFlow<ArrayList<LoopPadState>> =
        MutableStateFlow(ArrayList<LoopPadState>(listOf(LoopPadState.Stopped)))
    val recordingPads: StateFlow<ArrayList<LoopPadState>> = _recordingPads.asStateFlow()


    fun addPad() {
        if (_recordingPads.value.size < MAX_RECORDING_PADS) {
            _recordingPads.update { recordingPads ->
                ArrayList(recordingPads).apply { add(LoopPadState.Stopped) }
            }
            Log.d("LooperViewModel", "Pad added: ${_recordingPads.value.size}")
        }
    }

    fun removePad(index: Int) {
        _recordingPads.update { recordingPads ->
            ArrayList(recordingPads).apply { 
                if (index in 0 until size) removeAt(index) 
            }
        }
        Log.d("LooperViewModel", "Pad removed at index $index")
    }

    fun onLoopPadClick(index: Int) {
        _recordingPads.update { recordingPads ->
            ArrayList(recordingPads).apply {
                this[index] = when (this[index]) {
                    LoopPadState.Playing -> LoopPadState.Stopped
                    LoopPadState.Stopped -> if (isRecording.value) LoopPadState.Recording else LoopPadState.Playing
                    LoopPadState.Recording -> LoopPadState.Stopped
                }
            }
        }
    }
}


