package ru.otus.daggerhomework

import android.app.Application

class App : Application() {

    companion object {

        private lateinit var INSTANCE: ApplicationComponent

        fun getInstance() = INSTANCE
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = DaggerApplicationComponent.factory().getApplicationComponent(this)
    }
}