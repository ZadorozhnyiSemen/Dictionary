package com.semyon.dictionary.model

data class WordMeaning(
    val id: Int,
    val partOfSpeechCode: String,
    val translation: WordTranslation,
    val previewUrl: String?,
    val imageUrl: String?,
    val transcription: String,
    val soundUrl: String
)