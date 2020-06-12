package com.semyon.dictionary.screen.search.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.semyon.dictionary.model.FullMeaning

class SearchViewModel @ViewModelInject constructor(
    private val searchInteractor: SearchInteractor
) : ViewModel() {

    val searchResult: MutableLiveData<List<FullMeaning>> = MutableLiveData()
    val hasResults: MutableLiveData<Boolean> = MutableLiveData(true)

    fun changeSearchQuery(query: String) {
        searchInteractor.updateSearchResult(query)
    }
}