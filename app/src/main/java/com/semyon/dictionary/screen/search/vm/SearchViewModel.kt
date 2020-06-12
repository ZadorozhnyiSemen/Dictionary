package com.semyon.dictionary.screen.search.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class SearchViewModel @ViewModelInject constructor(
    private val searchInteractor: SearchInteractor
) : ViewModel() {
}