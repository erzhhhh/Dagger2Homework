package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface EventModule {

    @Binds
    @ActivityScope
    fun bindsEventManager(eventManagerImpl: EventManagerImpl): EventManager
}