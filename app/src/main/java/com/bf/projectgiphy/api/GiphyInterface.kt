package com.bf.projectgiphy.api

import com.bf.projectgiphy.domain.models.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyInterface {
    @GET("v1/gifs/search")
    fun getGifs(
        @Query("q") query: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("rating") rating: String,
        @Query("lan") language: String
    ): Call<Data>
}