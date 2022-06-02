package com.bf.projectgiphy.di

import com.bf.projectgiphy.app.di.GiphyComponent
import dagger.Module

@Module(
    subcomponents = [
        GiphyComponent::class
    ]
)
object FeaturesSubComponentModule