package com.bf.projectgiphy.di

import android.content.Context
import com.bf.projectgiphy.app.di.GiphyComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelBuilderModule::class,
        FeaturesSubComponentModule::class,
        ServicesModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    //Components
    fun createGiphyComponent(): GiphyComponent.Factory

}