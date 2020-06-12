package com.semyon.dictionary.screen.word.vm

import com.semyon.dictionary.model.FullMeaning
import com.semyon.dictionary.network.SkyEngApi
import io.reactivex.Maybe
import javax.inject.Inject

class WordInteractor @Inject constructor(
    private val api: SkyEngApi
) {
    fun requestWordMeaning(id: Int): Maybe<FullMeaning> {
        return api.requestMeaning(id.toString()).map { it -> it.first() }
    }
}