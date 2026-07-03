package com.toblad.khwab.speech

import android.content.Context
import android.util.Log

class ModelLoader(
        private val context: Context
) {

        companion object {
                    private const val TAG = "ModelLoader"

                            // Folder inside assets
                                    private const val MODEL_DIR = "models/zipformer"

                                            // Model filenames
                                                    const val ENCODER =
                                                                "encoder-epoch-99-avg-1-chunk-16-left-128.int8.onnx"

                                                                        const val DECODER =
                                                                                    "decoder-epoch-99-avg-1-chunk-16-left-128.int8.onnx"

                                                                                            const val JOINER =
                                                                                                        "joiner-epoch-99-avg-1-chunk-16-left-128.int8.onnx"

                                                                                                                const val TOKENS = "tokens.txt"
        }

            fun loadModel(): Boolean {
                        return try {

                                        val files = context.assets.list(MODEL_DIR) ?: emptyArray()

                                                    if (files.isEmpty()) {
                                                                        Log.e(TAG, "Model folder is empty!")
                                                                                        return false
                                                    }

                                                                val requiredFiles = listOf(
                                                                                    ENCODER,
                                                                                                    DECODER,
                                                                                                                    JOINER,
                                                                                                                                    TOKENS
                                                                )

                                                                            for (file in requiredFiles) {
                                                                                                if (!files.contains(file)) {
                                                                                                                        Log.e(TAG, "Missing model file: $file")
                                                                                                                                            return false
                                                                                                }
                                                                            }

                                                                                        Log.d(TAG, "Zipformer model verified successfully.")
                                                                                                    true

                        } catch (e: Exception) {
                                        Log.e(TAG, "Failed to load model.", e)
                                                    false
                        }
            }

                fun getModelDirectory(): String {
                            return MODEL_DIR
                }
}                         