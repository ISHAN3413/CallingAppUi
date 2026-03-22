package com.example.callingapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun CallNavGraph(viewModel: CallViewModel = viewModel(), modifier: Modifier) {

    val navController = rememberNavController()
    CallEffectsHandler(viewModel.callState)
    LaunchedEffect(viewModel.callState) {
        when (viewModel.callState) {

            CallState.IDLE -> {
                navController.navigate(Screen.DialPad.route) {
                    popUpTo(0)
                }
            }

            CallState.CALLING -> {
                navController.navigate(Screen.Calling.route) {
                    popUpTo(0)
                }
            }

            CallState.RINGING -> {
                navController.navigate(Screen.Incoming.route) {
                    popUpTo(0)
                }
            }

            CallState.ACTIVE -> {
                navController.navigate(Screen.Active.route) {
                    popUpTo(0)
                }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.DialPad.route,
        modifier = modifier
    ) {
        composable(Screen.DialPad.route) {
            DialPad(
                phoneNumber = viewModel.phoneNumber,
                onNumberChange = viewModel::updateNumber,
                onCallClick = {
                    viewModel.startCall()
                }
            )
        }

        composable(Screen.Calling.route) {
            OutgoingCallScreen(
                number = viewModel.phoneNumber,
                onEndCall = viewModel::endCall
            )
        }

        composable(Screen.Incoming.route) {
            IncomingCallScreen(
                number = viewModel.phoneNumber,
                onAccept = viewModel::acceptCall,
                onReject = viewModel::endCall
            )
        }

        composable(Screen.Active.route) {
            ActiveCallScreen(
                number = viewModel.phoneNumber,
                time = viewModel.callTime,
                isMuted = viewModel.isMuted,
                isSpeakerOn = viewModel.isSpeakerOn,
                onMuteToggle = { viewModel.isMuted = !viewModel.isMuted },
                onSpeakerToggle = { viewModel.isSpeakerOn = !viewModel.isSpeakerOn },
                onEndCall = viewModel::endCall
            )
        }
    }
}