package com.bf.projectgiphy.domain.useCases

import com.bf.projectgiphy.data.models.DataRequest
import com.bf.projectgiphy.domain.models.Gif
import com.bf.projectgiphy.domain.repositories.GiphyRepositoryInterface

class FetchGifsPg13EnglishUseCase constructor(
    private val giphyRepository: GiphyRepositoryInterface
) : BaseUseCase<List<Gif>, DataRequest> {

    override suspend fun invoke(param: DataRequest): List<Gif> {
        return giphyRepository.getGifs(
            query = param.query,
            limit = param.limit,
            offset = param.offset,
            rating = "pg-13",       //This use-case has a default setting for pg-13 rating
            language = "en"         //This use-case has english as a default language
        ).data
    }

    /*
    * Here we can handle the use case scenario before we access our domain layer.
    * We can also filter the data based on the use-case.
    * */
}