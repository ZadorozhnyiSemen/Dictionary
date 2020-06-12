package com.semyon.dictionary.screen.word.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.semyon.dictionary.model.FullMeaning
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class WordDetailViewModel @ViewModelInject constructor(
    private val wordInteractor: WordInteractor
) : ViewModel() {

    private val bag = CompositeDisposable()

    val word: MutableLiveData<FullMeaning> = MutableLiveData()

    fun loadWordInformation(wordId: Int) {
        bag.add(wordInteractor.requestWordMeaning(wordId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { wordMeaning ->
                    word.value = wordMeaning
                },
                { error ->
                    println("new error ${error.localizedMessage}")
                }
            )
        )
    }
}