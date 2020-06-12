package com.semyon.dictionary.model

data class FullMeaning(
    val id: Int,
    val wordId: Int,
    val difficultyLevel: Int,
    val partOfSpeechCode: String,
    val prefix: String,
    val text: String,
    val soundUrl: String,
    val transcription: String,
    val updatedAt: String,
    val mnemonics: String,
    val translation: WordTranslation,
    val images: List<WordImage>,
    val definition: WordDefinition,
    val examples: List<WordExample>
)

data class WordImage(val url: String)
data class WordDefinition(val text: String, val soundUrl: String)
data class WordExample(val text: String, val soundUrl: String)
