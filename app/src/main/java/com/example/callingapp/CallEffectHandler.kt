package com.example.callingapp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.example.callingapp.CallState
import com.example.callingapp.R
import com.example.callingapp.SoundManager
import com.example.callingapp.VibrationManager

@Composable
fun CallEffectsHandler(callState: CallState) {

    val context = LocalContext.current

    LaunchedEffect(callState) {

        when (callState) {

            CallState.CALLING -> {
                SoundManager.playSound(context, R.raw.calling)
                VibrationManager.stop(context)
            }

            CallState.RINGING -> {
                SoundManager.playSound(context, R.raw.ringtone)
                VibrationManager.vibrate(context)
            }

            CallState.ACTIVE -> {
                SoundManager.stop()
                VibrationManager.stop(context)
            }

            CallState.IDLE -> {
                SoundManager.stop()
                VibrationManager.stop(context)
            }
        }
    }
}