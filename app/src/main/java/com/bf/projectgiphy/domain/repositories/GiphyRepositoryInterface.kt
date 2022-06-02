package com.bf.projectgiphy.domain.repositories

import com.bf.projectgiphy.domain.models.Gif

interface GiphyRepositoryInterface {
    suspend fun getGifs(): List<Gif>
}