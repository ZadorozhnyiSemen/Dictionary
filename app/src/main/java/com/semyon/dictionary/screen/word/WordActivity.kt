package com.semyon.dictionary.screen.word

import android.annotation.SuppressLint
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
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
    private var mediaPlayer: MediaPlayer? = MediaPlayer().apply {
        setAudioAttributes(AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word)

        wordDetailsViewModel.word.observe(this, Observer { meaning ->
            Glide.with(this)
                .load("https:${meaning.images.first().url}")
                .centerCrop()
                .into(word_image)
            word_origin.text = meaning.text
            word_translation.text = meaning.translation.text
            word_transcription.text = "/${meaning.transcription}/"
            word_description.text = meaning.definition.text
            play_translation.setOnClickListener {
                mediaPlayer?.apply {
                    reset()
                    setDataSource(this@WordActivity, "https:${meaning.soundUrl}".toUri())
                    prepareAsync()
                    setOnPreparedListener {
                        it.start()
                    }
                }
            }
        })

        val wordId = intent.getIntExtra(WORD_ID_KEY, -1)
        wordDetailsViewModel.loadWordInformation(wordId)
    }

    override fun onStop() {
        mediaPlayer?.release()
        mediaPlayer = null
        super.onStop()
    }
}