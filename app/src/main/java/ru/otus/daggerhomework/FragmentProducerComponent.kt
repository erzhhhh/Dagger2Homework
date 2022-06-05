package ru.otus.daggerhomework

import dagger.Component
import javax.inject.Scope

@FragmentScope
@Component(dependencies = [MainActivityComponent::class], modules = [ColorGeneratorModule::class])
interface FragmentProducerComponent {

    fun inject(fragmentProducer: FragmentProducer)

    @Component.Factory
    interface Factory {
        fun createFragmentProducerComponent(mainActivityComponent: MainActivityComponent): FragmentProducerComponent
    }
}

@Scope
annotation class FragmentScope