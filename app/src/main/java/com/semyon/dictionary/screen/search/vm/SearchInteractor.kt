package com.semyon.dictionary.screen.search.vm

import com.semyon.dictionary.model.PreviewWord
import com.semyon.dictionary.network.SkyEngApi
import io.reactivex.Maybe
import javax.inject.Inject

class SearchInteractor @Inject constructor(
    private val api: SkyEngApi
) {
    fun updateSearchResult(query: String): Maybe<List<PreviewWord>> {
        if (query.length <= 2) return Maybe.just(listOf())
        return api.search(query)
    }
}
