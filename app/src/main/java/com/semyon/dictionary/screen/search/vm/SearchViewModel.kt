package com.semyon.dictionary.screen.search.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.semyon.dictionary.model.FullMeaning
import com.semyon.dictionary.model.PreviewWord
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchViewModel @ViewModelInject constructor(
    private val searchInteractor: SearchInteractor
) : ViewModel() {

    private val bag = CompositeDisposable()

    val searchResult: MutableLiveData<List<PreviewWord>> = MutableLiveData()
    val hasResults: MutableLiveData<Boolean> = MutableLiveData(false)

    fun changeSearchQuery(query: String) {
        bag.add(searchInteractor.updateSearchResult(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { results ->
                    println("new result $results")
                    hasResults.value = results.isNotEmpty()
                    searchResult.value = results
                },
                { error ->
                    println("new error ${error.localizedMessage}")
                    // Some error. Just show empty list
                    hasResults.value = false
                }
            ))
    }
}