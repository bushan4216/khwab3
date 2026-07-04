package com.toblad.khwab.speech

import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.util.Log

class AudioRecorder {

    companion object {
        private const val TAG = "AudioRecorder"

        const val SAMPLE_RATE = 16000
        const val CHANNEL_CONFIG = AudioFormat.CHANNEL_IN_MONO
        const val AUDIO_FORMAT = AudioFormat.ENCODING_PCM_16BIT
    }

    private val bufferSize = AudioRecord.getMinBufferSize(
        SAMPLE_RATE,
        CHANNEL_CONFIG,
        AUDIO_FORMAT
    )

    private var audioRecord: AudioRecord? = null
    private var isRecording = false

    fun startRecording() {
        if (isRecording) return

        audioRecord = AudioRecord(
            MediaRecorder.AudioSource.VOICE_RECOGNITION,
            SAMPLE_RATE,
            CHANNEL_CONFIG,
            AUDIO_FORMAT,
            bufferSize
        )

        audioRecord?.startRecording()
        isRecording = true

        Log.d(TAG, "Recording started")
    }

    fun stopRecording() {
        if (!isRecording) return

        audioRecord?.stop()
        audioRecord?.release()
        audioRecord = null

        isRecording = false

        Log.d(TAG, "Recording stopped")
    }

    fun read(buffer: ShortArray): Int {
        return audioRecord?.read(buffer, 0, buffer.size) ?: 0
    }

    fun isRecording(): Boolean = isRecording
}