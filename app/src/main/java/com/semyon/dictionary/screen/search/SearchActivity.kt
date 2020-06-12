package com.semyon.dictionary.screen.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.semyon.dictionary.R
import com.semyon.dictionary.screen.search.adapter.SearchResultAdapter
import com.semyon.dictionary.screen.search.vm.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_search.*

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var searchAdapter: SearchResultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchViewModel.searchResult.observe(this, Observer { list ->
            println(list)
            searchAdapter.searchItems = ArrayList(list)
        })

        searchViewModel.hasResults.observe(this, Observer { showList ->
            words_result.visibility = if (showList) View.VISIBLE else View.GONE
            hint.visibility = if (showList) View.GONE else View.VISIBLE
        })

        searchAdapter = SearchResultAdapter()
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
    }
}
