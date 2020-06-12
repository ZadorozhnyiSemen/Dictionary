package com.semyon.dictionary.repository.cache

import com.semyon.dictionary.model.FullMeaning

class MeaningCache {
    private val cache: HashMap<String, List<FullMeaning>> = hashMapOf()

    fun meaningForWord(wordId: String): List<FullMeaning>? {
        return cache[wordId]
    }

    fun saveWord(wordId: String, words: List<FullMeaning>) {
        cache[wordId] = words
        println(cache.size)
    }
}