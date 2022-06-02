package com.bf.projectgiphy.data.repositories

import com.bf.projectgiphy.data.source.GiphyDataSourceInterface
import com.bf.projectgiphy.domain.models.Data
import com.bf.projectgiphy.domain.repositories.GiphyRepositoryInterface
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class GiphyRepository @Inject constructor(
    private val giphyDataSource: GiphyDataSourceInterface
) : GiphyRepositoryInterface {

    override suspend fun getGifs(
        query: String,
        limit: Int,
        offset: Int,
        rating: String,
        language: String
    ): Data = giphyDataSource.getGifs(query, limit, offset, rating, language)

    /*
    * Would provide local data source here if there was no internet connection
    * */
}