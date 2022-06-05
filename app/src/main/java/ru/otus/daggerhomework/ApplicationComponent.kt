package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    @Named("ApplicationContext")
    fun provideApplicationContext(): Context

    @Component.Factory
    interface Factory {
        fun getApplicationComponent(@BindsInstance @Named("ApplicationContext") context: Context): ApplicationComponent
    }
}