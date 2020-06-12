package com.semyon.dictionary.model

data class PreviewWord(
    val id: Int,
    val text: String,
    val meanings: List<WordMeaning>

)

data class WordMeaning(
    val id: Int,
    val partOfSpeechCode: String,
    val translation: WordTranslation,
    val previewUrl: String,
    val imageUrl: String,
    val transcription: String,
    val soundUrl: String
)

