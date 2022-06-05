package ru.otus.daggerhomework

import dagger.Component
import javax.inject.Singleton

@FragmentScope
@Component(dependencies = [MainActivityComponent::class])
interface FragmentReceiverComponent {

    fun inject(fragmentReceiver: FragmentReceiver)

    @Component.Factory
    interface Factory {
        fun createFragmentReceiverComponent(mainActivityComponent: MainActivityComponent): FragmentReceiverComponent
    }
}