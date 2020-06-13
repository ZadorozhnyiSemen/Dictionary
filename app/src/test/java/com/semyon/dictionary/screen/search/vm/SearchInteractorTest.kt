package com.semyon.dictionary.screen.search.vm

import com.semyon.dictionary.previewList
import com.semyon.dictionary.repository.WordRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Maybe
import org.junit.Before
import org.junit.Test

class SearchInteractorTest {

    @MockK
    lateinit var mockedRepository: WordRepository
    lateinit var searchInteractor: SearchInteractor

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        searchInteractor = SearchInteractor(mockedRepository)
    }

    @Test
    fun `If small query interactor should return empty list`() {
        searchInteractor.updateSearchResult("sm")
            .test()
            .assertOf {
                it.assertValue(listOf())
            }
    }

    @Test
    fun `If query is valid should return some real data`() {
        every { mockedRepository.searchForWord("real") }.returns(Maybe.just(previewList))

        searchInteractor.updateSearchResult("real")
            .test()
            .assertOf {
                it.assertValue(previewList)
            }
    }
}