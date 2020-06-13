package com.semyon.dictionary

import com.semyon.dictionary.model.*

val translation = WordTranslation("empty", "empty")
val images = listOf(WordImage("test"))
val wordDefinition = WordDefinition("test", "test")
val wordExamples = listOf(WordExample("test", "test"))

val firstFullMeaning = FullMeaning(1, 42, 4, "empty",
    "empty", "empty", "empty", "empty", "empty",
    "empty", translation, images, wordDefinition, wordExamples)

val secondFullMeaning = FullMeaning(2, 43, 4, "empty",
    "empty", "empty", "empty", "empty", "empty",
    "empty", translation, images, wordDefinition, wordExamples)

val meaningList = listOf<FullMeaning>(
    firstFullMeaning,
    secondFullMeaning
)