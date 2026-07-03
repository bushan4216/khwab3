package com.toblad.khwab.speech

import android.content.Context
import android.util.Log

class SpeechRecognizer(
        private val context: Context
) {

        companion object {
                    private const val TAG = "SpeechRecognizer"
        }

            fun initialize() {
                        Log.d(TAG, "Initializing OnlineRecognizer...")
            }

                fun start() {
                            Log.d(TAG, "Recognition started.")
                }

                    fun stop() {
                                Log.d(TAG, "Recognition stopped.")
                    }
}