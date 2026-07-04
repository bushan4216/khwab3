package com.toblad.khwab.speech

object RecognizerConfig {

    const val SAMPLE_RATE = 16000
    const val FEATURE_DIM = 80
    const val NUM_THREADS = 2

    const val MODEL_DIR = "models/zipformer"

    const val ENCODER =
        "encoder-epoch-99-avg-1-chunk-16-left-128.int8.onnx"

    const val DECODER =
        "decoder-epoch-99-avg-1-chunk-16-left-128.int8.onnx"

    const val JOINER =
        "joiner-epoch-99-avg-1-chunk-16-left-128.int8.onnx"

    const val TOKENS = "tokens.txt"
}