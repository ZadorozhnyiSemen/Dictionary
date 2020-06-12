package com.semyon.dictionary.screen.word.vm

import com.semyon.dictionary.model.FullMeaning
import com.semyon.dictionary.repository.WordRepository
import io.reactivex.Maybe
import javax.inject.Inject

class WordInteractor @Inject constructor(
    private val wordRepository: WordRepository
) {
    fun requestWordMeaning(id: Int): Maybe<FullMeaning> =
        wordRepository.meaning(id.toString()).map { it.first() }
}