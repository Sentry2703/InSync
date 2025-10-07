package com.android.insync

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.android.insync.ui.LooperScreen
import com.android.insync.ui.theme.InSyncTheme
import com.android.insync.utils.PermissionRationale
import com.android.insync.viewmodel.LooperViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            InSyncTheme {
                LooperScreenHost()
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LooperScreenHost(
    modifier: Modifier = Modifier,
    viewModel: LooperViewModel = LooperViewModel(),
) {
    val permissionState = rememberPermissionState(
        android.Manifest.permission.RECORD_AUDIO
    )

    when {
        permissionState.status.isGranted -> {
            LooperScreen(
                modifier = modifier,
                viewModel = viewModel
            )
        }
        permissionState.status.shouldShowRationale -> {
            PermissionRationale(
                onGrantClicked = { permissionState.launchPermissionRequest() }
            )
        }
        else -> {
            LaunchedEffect(Unit) {
                permissionState.launchPermissionRequest()
            }
        }
    }
}