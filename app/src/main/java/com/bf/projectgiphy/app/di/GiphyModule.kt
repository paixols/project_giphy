package com.bf.projectgiphy.app.di

import androidx.lifecycle.ViewModel
import com.bf.projectgiphy.app.ui.MainViewModel
import com.bf.projectgiphy.data.repositories.GiphyRepository
import com.bf.projectgiphy.data.source.GiphyDataSource
import com.bf.projectgiphy.data.source.GiphyDataSourceInterface
import com.bf.projectgiphy.di.ViewModelKey
import com.bf.projectgiphy.domain.repositories.GiphyRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Module(
    includes = [
        FetchGiphyUseCaseModule::class
    ]
)
abstract class GiphyModule {

    @Binds
    abstract fun provideGiphyDataSource(gifDataSource: GiphyDataSource): GiphyDataSourceInterface

    @ExperimentalCoroutinesApi
    @Binds
    abstract fun providesGiphyRepository(giphyRepository: GiphyRepository): GiphyRepositoryInterface

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(viewModel: MainViewModel): ViewModel

}