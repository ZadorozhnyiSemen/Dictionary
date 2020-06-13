package com.semyon.dictionary

import com.semyon.dictionary.model.*

val translation = WordTranslation("empty", "empty")
val images = listOf(WordImage("test"))
val wordDefinition = WordDefinition("test", "test")
val wordMeaning = WordMeaning(2, "f", translation, null,
    null , "test", "test")
val wordExamples = listOf(WordExample("test", "test"))

val firstFullMeaning = FullMeaning(1, 42, 4, "empty",
    "empty", "empty", "empty", "empty", "empty",
    "empty", translation, images, wordDefinition, wordExamples)

val secondFullMeaning = FullMeaning(2, 43, 4, "empty",
    "empty", "empty", "empty", "empty", "empty",
    "empty", translation, images, wordDefinition, wordExamples)

val meaningList = listOf(
    firstFullMeaning,
    secondFullMeaning
)

val previewList = listOf(
    PreviewWord(1, "test1", listOf(wordMeaning)),
    PreviewWord(2, "test2", listOf(wordMeaning)),
    PreviewWord(3, "test3", listOf(wordMeaning))
)