package com.example.finalproject.presentation

import android.app.Application
import com.example.finalproject.di.ApplicationComponent
import com.example.finalproject.di.DaggerApplicationComponent

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}
