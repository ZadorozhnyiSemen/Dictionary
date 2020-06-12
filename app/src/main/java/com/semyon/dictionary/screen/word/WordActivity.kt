package com.semyon.dictionary.screen.word

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.semyon.dictionary.R
import com.semyon.dictionary.screen.word.vm.WordDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_word.*

const val WORD_ID_KEY = "word_id_key"

@AndroidEntryPoint
class WordActivity : AppCompatActivity() {

    private val wordDetailsViewModel: WordDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        wordDetailsViewModel.word.observe(this, Observer {
            Glide.with(this)
                .load("https:${it.images.first().url}")
                .centerCrop()
                .into(word_image)
        })

        val wordId = intent.getIntExtra(WORD_ID_KEY, -1)
        wordDetailsViewModel.loadWordInformation(wordId)
    }
}