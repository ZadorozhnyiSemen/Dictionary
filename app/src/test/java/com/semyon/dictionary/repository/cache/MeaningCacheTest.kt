package com.semyon.dictionary.repository.cache

import com.semyon.dictionary.meaningList
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class MeaningCacheTest {

    private lateinit var meaningCache: MeaningCache

    @Before
    fun setUp() {
        meaningCache = MeaningCache()
    }

    @Test
    fun `Test meaning cache saves meanings to use them later`() {
        val word = "test"
        meaningCache.saveWord(word, meaningList)

        assertEquals(meaningList, meaningCache.meaningForWord(word))
    }

    @Test
    fun `With word not in cache should return null`() {
        assertNull(meaningCache.meaningForWord("Not cached word"))
    }
}