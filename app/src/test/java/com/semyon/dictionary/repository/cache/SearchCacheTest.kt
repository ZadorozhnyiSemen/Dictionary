package com.semyon.dictionary.repository.cache

import com.semyon.dictionary.previewList
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class SearchCacheTest {

    private lateinit var searchCache: SearchCache

    @Before
    fun setUp() {
        searchCache = SearchCache()
    }

    @Test
    fun `Cache stores results for given query`() {
        val query = "test"
        searchCache.saveItems(query, previewList)

        assertEquals(previewList, searchCache.itemsForQuery(query))
    }

    @Test
    fun `If nothing saved for query cache returns null`() {
        assertNull(searchCache.itemsForQuery("First appearance"))
    }
}