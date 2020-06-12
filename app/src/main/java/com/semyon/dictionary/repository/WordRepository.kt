package com.semyon.dictionary.repository

import com.semyon.dictionary.model.FullMeaning
import com.semyon.dictionary.model.PreviewWord
import io.reactivex.Maybe

interface WordRepository {
    fun searchForWord(query: String): Maybe<List<PreviewWord>>
    fun meaning(wordIds: String): Maybe<List<FullMeaning>>
}