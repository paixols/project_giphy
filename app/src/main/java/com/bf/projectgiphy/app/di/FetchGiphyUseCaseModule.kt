package com.bf.projectgiphy.app.di

import com.bf.projectgiphy.domain.repositories.GiphyRepositoryInterface
import com.bf.projectgiphy.domain.useCases.FetchGifsPg13EnglishUseCase
import dagger.Module
import dagger.Provides

@Module
object FetchGiphyUseCaseModule {
    @Provides
    fun provideFetchGiphyUseCase(giphyRepositoryInterface: GiphyRepositoryInterface): FetchGifsPg13EnglishUseCase =
        FetchGifsPg13EnglishUseCase(giphyRepositoryInterface)
}