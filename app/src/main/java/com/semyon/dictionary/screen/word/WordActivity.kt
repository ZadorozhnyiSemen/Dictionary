package com.semyon.dictionary.screen.word

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.semyon.dictionary.R
import dagger.hilt.android.AndroidEntryPoint

const val WORD_ID_KEY = "word_id_key"

@AndroidEntryPoint
class WordActivity : AppCompatActivity() {

    private val wordDetailsViewModel: WordDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)
    }
}