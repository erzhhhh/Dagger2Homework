package ru.otus.daggerhomework

import dagger.Binds
import dagger.Module

@Module
interface ColorGeneratorModule {

    @Binds
    @FragmentScope
    fun bindColorGenerator(colorGeneratorImpl: ColorGeneratorImpl): ColorGenerator
}