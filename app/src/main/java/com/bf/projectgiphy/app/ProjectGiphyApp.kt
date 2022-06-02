package com.bf.projectgiphy.app

import android.app.Application

class ProjectGiphyApp: Application() {

    val appComponent by lazy {
        initAppComponent()
    }

    private fun initAppComponent() {
        TODO("Not yet implemented")
    }
}