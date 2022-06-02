package com.bf.projectgiphy.domain.useCases

import com.bf.projectgiphy.domain.models.Gif
import com.bf.projectgiphy.domain.repositories.GiphyRepositoryInterface

class FetchGifsUseCase constructor(
    private val giphyRepository: GiphyRepositoryInterface
) : BaseUseCase<List<Gif>, Unit> {

    override suspend fun invoke(param: Unit): List<Gif> {
        TODO("Not yet implemented")
    }
}