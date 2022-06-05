package ru.otus.daggerhomework

import androidx.annotation.ColorInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@ActivityScope
class EventManagerImpl @Inject constructor() : EventManager {

    private val eventManagerLiveData: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    override fun set(@ColorInt color: Int) {
        eventManagerLiveData.value = color
    }

    override fun observe(): LiveData<Int> {
        return eventManagerLiveData
    }

}