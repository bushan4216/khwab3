package com.toblad.khwab.speech

import android.content.Context
import android.util.Log

class SherpaManager(
    private val context: Context
) {

    companion object {
        private const val TAG = "SherpaManager"
    }

    private val audioRecorder = AudioRecorder()
    private val sherpaEngine = SherpaEngine(context)

    fun initialize(): Boolean {

        Log.d(TAG, "Initializing Sherpa Manager...")

        val initialized = sherpaEngine.initialize()

        if (!initialized) {
            Log.e(TAG, "Failed to initialize Sherpa Engine")
            return false
        }

        Log.d(TAG, "Sherpa Manager initialized successfully")
        return true
    }

    fun startListening() {

        Log.d(TAG, "Starting listening...")

        audioRecorder.startRecording()
        sherpaEngine.start()
    }

    fun stopListening() {

        Log.d(TAG, "Stopping listening...")

        audioRecorder.stopRecording()
        sherpaEngine.stop()
    }

    fun release() {

        Log.d(TAG, "Releasing Sherpa Manager...")

        audioRecorder.stopRecording()
        sherpaEngine.release()
    }
}