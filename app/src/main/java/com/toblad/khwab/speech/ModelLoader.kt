package com.toblad.khwab.speech

import android.content.Context
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class ModelLoader(
    private val context: Context
) {

    companion object {
        private const val TAG = "ModelLoader"
        private const val MODEL_DIR = "models/zipformer"
    }

    fun loadModel(): Boolean {
        return try {

            copyAsset("encoder-epoch-99-avg-1-chunk-16-left-128.int8.onnx")
            copyAsset("decoder-epoch-99-avg-1-chunk-16-left-128.int8.onnx")
            copyAsset("joiner-epoch-99-avg-1-chunk-16-left-128.int8.onnx")
            copyAsset("tokens.txt")
            copyAsset("bpe.model")

            Log.d(TAG, "All model files loaded.")

            true

        } catch (e: Exception) {
            Log.e(TAG, "Failed to load model", e)
            false
        }
    }

    private fun copyAsset(fileName: String): String {

        val outFile = File(context.filesDir, fileName)

        if (outFile.exists()) {
            return outFile.absolutePath
        }

        context.assets.open("$MODEL_DIR/$fileName").use { input ->
            FileOutputStream(outFile).use { output ->
                input.copyTo(output)
            }
        }

        return outFile.absolutePath
    }

    fun encoderPath() =
        File(context.filesDir,
            "encoder-epoch-99-avg-1-chunk-16-left-128.int8.onnx").absolutePath

    fun decoderPath() =
        File(context.filesDir,
            "decoder-epoch-99-avg-1-chunk-16-left-128.int8.onnx").absolutePath

    fun joinerPath() =
        File(context.filesDir,
            "joiner-epoch-99-avg-1-chunk-16-left-128.int8.onnx").absolutePath

    fun tokensPath() =
        File(context.filesDir,
            "tokens.txt").absolutePath

    fun bpePath() =
        File(context.filesDir,
            "bpe.model").absolutePath
}