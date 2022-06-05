package ru.otus.daggerhomework

import androidx.lifecycle.LiveData

interface EventManager {

    fun set(color: Int)

    fun observe(): LiveData<Int>
}