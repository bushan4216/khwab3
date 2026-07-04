package com.toblad.khwab.speech.sherpa

import android.content.Context
import android.util.Log

class SherpaInitializer(
    private val context: Context
) {

    companion object {
        private const val TAG = "SherpaInitializer"
    }

    fun initialize(): Boolean {

        Log.d(TAG, "Initializing Sherpa...")

        // Next:
        // FeatureConfig
        // OnlineModelConfig
        // OnlineRecognizerConfig
        // OnlineRecognizer

        Log.d(TAG, "Sherpa initialized.")

        return true
    }
}