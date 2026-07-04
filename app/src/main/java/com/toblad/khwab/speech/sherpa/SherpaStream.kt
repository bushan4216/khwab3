package com.toblad.khwab.speech.sherpa

import android.util.Log

class SherpaStream {

    companion object {
        private const val TAG = "SherpaStream"
    }

    fun create() {
        Log.d(TAG, "Creating Sherpa stream...")
    }

    fun acceptSamples(samples: FloatArray) {
        Log.d(TAG, "Received ${samples.size} samples")
    }

    fun decode() {
        Log.d(TAG, "Decoding...")
    }

    fun reset() {
        Log.d(TAG, "Reset stream")
    }
}