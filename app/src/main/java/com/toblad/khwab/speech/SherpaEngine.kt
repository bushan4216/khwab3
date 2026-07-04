package com.toblad.khwab.speech

import android.content.Context
import android.util.Log

class SherpaEngine(
    private val context: Context
) {

    companion object {
        private const val TAG = "SherpaEngine"
    }

    private val modelLoader = ModelLoader(context)

    fun initialize(): Boolean {

        Log.d(TAG, "Initializing Sherpa Engine...")

        if (!modelLoader.loadModel()) {
            Log.e(TAG, "Failed to load models")
            return false
        }

        Log.d(TAG, "Models loaded successfully")

        // Next:
        // FeatureConfig
        // OnlineModelConfig
        // OnlineRecognizerConfig
        // OnlineRecognizer
        // OnlineStream

        return true
    }

    fun start() {
        Log.d(TAG, "Start recognition")
    }

    fun stop() {
        Log.d(TAG, "Stop recognition")
    }

    fun release() {
        Log.d(TAG, "Release engine")
    }
}