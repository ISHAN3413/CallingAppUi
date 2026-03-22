package com.example.callingapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CallViewModel : ViewModel() {
    var callState by mutableStateOf(CallState.IDLE)
        private set

    var phoneNumber by mutableStateOf("")
        private set

    var callTime by mutableStateOf(0)
        private set

    var isMuted by mutableStateOf(false)
    var isSpeakerOn by mutableStateOf(false)

    init {
        viewModelScope.launch {
            delay(15000)
            receiveCall("Ishan Agarwal")
        }
    }
    fun updateNumber(number: String) {
        phoneNumber = number
    }
    suspend fun recievedOutgoingcall(){
        delay(5000)
        if(callState == CallState.IDLE)return
        acceptCall()
    }
    fun startCall() {
        if (phoneNumber.isNotEmpty()) {
            callState = CallState.CALLING
            viewModelScope.launch { recievedOutgoingcall() }
        }
    }

    fun receiveCall(number: String) {
        phoneNumber = number
        callState = CallState.RINGING
    }

    fun acceptCall() {
        callState = CallState.ACTIVE
        startTimer()
    }

    fun endCall() {
        callState = CallState.IDLE
        phoneNumber = ""
        callTime = 0
    }

    private fun startTimer() {
        viewModelScope.launch {
            while (callState == CallState.ACTIVE) {
                delay(1000)
                callTime++
            }
        }
    }
}