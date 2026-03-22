package com.example.callingapp

import android.content.Context
import android.media.MediaPlayer

object SoundManager {

    private var mediaPlayer: MediaPlayer? = null
    fun playSound(context: Context, resId: Int, loop: Boolean = true) {
        stop()
        mediaPlayer = MediaPlayer.create(context, resId).apply {
            isLooping = loop
            start()
        }
    }

    fun stop() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}