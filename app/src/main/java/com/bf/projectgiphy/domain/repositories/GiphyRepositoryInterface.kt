package com.bf.projectgiphy.domain.repositories

import com.bf.projectgiphy.domain.models.Data

interface GiphyRepositoryInterface {
    suspend fun getGifs(
        query: String,
        limit: Int,
        offset: Int,
        rating: String,
        language: String
    ): Data
}