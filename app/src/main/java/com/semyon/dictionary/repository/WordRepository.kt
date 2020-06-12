package com.semyon.dictionary.repository

interface WordRepository {
    fun searchForWord(query: String)
    fun meaning(wordIds: String)
}