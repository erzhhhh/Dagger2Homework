package ru.otus.daggerhomework

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Scope

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [EventModule::class])
interface MainActivityComponent {

    fun provideEventManager(): EventManager

    @Named("ApplicationContext")
    fun provideApplicationContext(): Context

    @Named("mainActivityContext")
    fun provideMainActivityContext(): Context

    @Component.Factory
    interface Factory {
        fun getActivityComponent(
            @BindsInstance @Named("mainActivityContext") context: Context,
            applicationComponent: ApplicationComponent
        ): MainActivityComponent
    }
}

@Scope
annotation class ActivityScope