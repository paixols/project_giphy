package com.bf.projectgiphy.app.di

import com.bf.projectgiphy.domain.repositories.GiphyRepositoryInterface
import com.bf.projectgiphy.domain.useCases.FetchGifsUseCase
import dagger.Module
import dagger.Provides

@Module
object FetchGiphyUseCaseModule {
    @Provides
    fun provideFetchGiphyUseCase(giphyRepositoryInterface: GiphyRepositoryInterface): FetchGifsUseCase =
        FetchGifsUseCase(giphyRepositoryInterface)
}