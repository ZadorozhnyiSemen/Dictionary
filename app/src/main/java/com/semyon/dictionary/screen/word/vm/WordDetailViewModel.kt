package com.semyon.dictionary.screen.word.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class WordDetailViewModel @ViewModelInject constructor(
    private val wordInteractor: WordInteractor
) : ViewModel() {
}