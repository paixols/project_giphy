package com.bf.projectgiphy.app.di

import com.bf.projectgiphy.app.ui.MainActivity
import dagger.Subcomponent

@Subcomponent(
    modules = [
        GiphyModule::class
    ]
)
interface GiphyComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): GiphyComponent
    }

    fun inject(activity: MainActivity)

}