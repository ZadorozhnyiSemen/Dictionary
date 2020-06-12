package com.semyon.dictionary.network

import retrofit2.http.GET
import retrofit2.http.Query

interface SkyEngApi {

    @GET("/api/public/v1/words/search")
    fun search(
        @Query(value = "search") query: String,
        @Query(value = "page") page: Int = 0,
        @Query(value = "pageSize") size: Int = 20
    )

    @GET("/api/public/v1/meanings")
    fun requestMeaning(@Query(value = "ids") ids: String)
}