package com.semyon.dictionary.screen.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.semyon.dictionary.R
import com.semyon.dictionary.model.PreviewWord
import com.semyon.dictionary.screen.search.adapter.SearchResultAdapter
import com.semyon.dictionary.screen.search.vm.SearchViewModel
import com.semyon.dictionary.screen.word.WORD_ID_KEY
import com.semyon.dictionary.screen.word.WordActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_search.*

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var searchAdapter: SearchResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchViewModel.searchResult.observe(this, Observer { list ->4
            searchAdapter.searchItems = ArrayList(list)
        })

        searchViewModel.hasResults.observe(this, Observer { showList ->
            words_result.visibility = if (showList) View.VISIBLE else View.GONE
            hint.visibility = if (showList) View.GONE else View.VISIBLE
        })

        searchAdapter = SearchResultAdapter { item ->
            openDetails(item)
        }
        words_result.apply {
            adapter = searchAdapter
        }

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    searchViewModel.changeSearchQuery(it)
                    return true
                }
                return false
            }
        })
        search.imeOptions = search.imeOptions or EditorInfo.IME_FLAG_NO_EXTRACT_UI
    }

    private fun openDetails(word: PreviewWord) {
        startActivity(Intent(this, WordActivity::class.java).apply {
            putExtra(WORD_ID_KEY, word.meanings.first().id)
        })
    }
}
