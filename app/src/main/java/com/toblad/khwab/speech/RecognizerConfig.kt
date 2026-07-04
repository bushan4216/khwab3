package com.toblad.khwab.speech

object RecognizerConfig {

    const val SAMPLE_RATE = 16000
    const val FEATURE_DIM = 80
    const val NUM_THREADS = 2

    const val MODEL_DIR = "models/zipformer"

    const val ENCODER =
        "$MODEL_DIR/encoder-epoch-99-avg-1-chunk-16-left-128.int8.onnx"

    const val DECODER =
        "$MODEL_DIR/decoder-epoch-99-avg-1-chunk-16-left-128.int8.onnx"

    const val JOINER =
        "$MODEL_DIR/joiner-epoch-99-avg-1-chunk-16-left-128.int8.onnx"

    const val TOKENS =
        "$MODEL_DIR/tokens.txt"

    const val BPE =
        "$MODEL_DIR/bpe.model"
}