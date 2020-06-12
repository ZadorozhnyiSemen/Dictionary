package com.semyon.dictionary.repository.network

import com.semyon.dictionary.model.FullMeaning
import com.semyon.dictionary.model.PreviewWord
import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Query

interface SkyEngApi {

    @GET("/api/public/v1/words/search")
    fun search(
        @Query(value = "search") query: String,
        @Query(value = "page") page: Int = 0,
        @Query(value = "pageSize") size: Int = 20
    ): Maybe<List<PreviewWord>>

    @GET("/api/public/v1/meanings")
    fun requestMeaning(@Query(value = "ids") ids: String): Maybe<List<FullMeaning>>
}