package com.bf.projectgiphy.data.source

import com.bf.projectgiphy.domain.models.Data
import kotlinx.coroutines.ExperimentalCoroutinesApi

interface GiphyDataSourceInterface {

    @ExperimentalCoroutinesApi
    suspend fun getGifs(
        query: String,
        limit: Int,
        offset: Int,
        rating: String,
        language: String
    ): Data

}