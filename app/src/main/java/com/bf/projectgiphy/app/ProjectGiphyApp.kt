package com.bf.projectgiphy.app

import android.app.Application
import com.bf.projectgiphy.di.DaggerAppComponent

class ProjectGiphyApp : Application() {

    val appComponent by lazy {
        initAppComponent()
    }

    private fun initAppComponent() {
        DaggerAppComponent.factory().create(applicationContext)
    }
}