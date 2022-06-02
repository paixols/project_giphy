package com.bf.projectgiphy.app

import android.app.Application
import com.bf.projectgiphy.di.AppComponent
import com.bf.projectgiphy.di.DaggerAppComponent

class ProjectGiphyApp : Application() {

    val appComponent: AppComponent by lazy {
        initAppComponent()
    }

    private fun initAppComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}