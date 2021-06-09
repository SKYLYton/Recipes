package com.recipes

import android.app.Application
import com.recipes.di.AppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        initDagger()
    }

    companion object {
        lateinit var instance: App
            private set
        @JvmStatic lateinit var appComponent: AppComponent
    }

    private fun initDagger() {
        //appComponent = DaggerAppComponent.builder().build()
    }
}