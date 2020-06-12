package com.semyon.dictionary.repository.cache

import com.semyon.dictionary.model.PreviewWord

class SearchCache {
    private val cache: HashMap<String, List<PreviewWord>> = hashMapOf()

    fun itemsForQuery(query: String): List<PreviewWord>? {
        return cache[query]
    }

    fun saveItems(query: String, words: List<PreviewWord>) {
        cache[query] = words
    }
}