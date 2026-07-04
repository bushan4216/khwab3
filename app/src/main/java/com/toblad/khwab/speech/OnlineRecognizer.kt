package com.toblad.khwab.speech

import android.content.Context
import android.util.Log

class OnlineRecognizer(
    private val context: Context
) {

    companion object {
        private const val TAG = "OnlineRecognizer"
    }

    private var initialized = false

    fun initialize(): Boolean {
        return try {

            Log.d(TAG, "Initializing OnlineRecognizer")

            Log.d(TAG, "Model Directory: ${RecognizerConfig.MODEL_DIR}")
            Log.d(TAG, "Encoder: ${RecognizerConfig.ENCODER}")
            Log.d(TAG, "Decoder: ${RecognizerConfig.DECODER}")
            Log.d(TAG, "Joiner: ${RecognizerConfig.JOINER}")
            Log.d(TAG, "Tokens: ${RecognizerConfig.TOKENS}")

            initialized = true

            Log.d(TAG, "OnlineRecognizer initialized successfully.")

            true

        } catch (e: Exception) {
            Log.e(TAG, "Initialization failed", e)
            false
        }
    }

    fun isInitialized() = initialized

    fun startListening() {
        if (!initialized) {
            Log.e(TAG, "Recognizer not initialized")
            return
        }

        Log.d(TAG, "Listening started...")
    }

    fun stopListening() {
        Log.d(TAG, "Listening stopped...")
    }
}