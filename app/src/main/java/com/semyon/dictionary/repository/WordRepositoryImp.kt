package com.semyon.dictionary.repository

import com.semyon.dictionary.model.FullMeaning
import com.semyon.dictionary.model.PreviewWord

import com.semyon.dictionary.repository.cache.MeaningCache
import com.semyon.dictionary.repository.cache.SearchCache
import com.semyon.dictionary.repository.network.SkyEngApi
import io.reactivex.Maybe
import javax.inject.Inject

class WordRepositoryImp @Inject constructor(
    private val api: SkyEngApi,
    private val searchCache: SearchCache,
    private val meaningCache: MeaningCache
) : WordRepository {
    override fun searchForWord(query: String): Maybe<List<PreviewWord>> {
        searchCache.itemsForQuery(query)?.let {
            return Maybe.just(it)
        }

        return api.search(query).doAfterSuccess {
            searchCache.saveItems(query, it)
        }
    }

    override fun meaning(wordIds: String): Maybe<List<FullMeaning>> {
        meaningCache.meaningForWord(wordIds)?.let {
            return Maybe.just(it)
        }

        return api.requestMeaning(wordIds).doAfterSuccess {
            meaningCache.saveWord(wordIds, it)
        }
    }
}