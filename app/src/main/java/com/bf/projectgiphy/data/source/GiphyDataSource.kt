package com.bf.projectgiphy.data.source

import com.bf.projectgiphy.api.GiphyService
import com.bf.projectgiphy.domain.models.Data
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

class GiphyDataSource @Inject constructor(
    private val giphyApi: GiphyService
) : GiphyDataSourceInterface {

    @ExperimentalCoroutinesApi
    override suspend fun getGifs(
        query: String,
        limit: Int,
        offset: Int,
        rating: String,
        language: String
    ): Data = giphyApi.getGifs(query, limit, offset, rating, language)

    /*
    * We could choose multiple data sources based on availability
    * */

}