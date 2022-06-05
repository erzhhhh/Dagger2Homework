package ru.otus.daggerhomework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class FragmentReceiverViewModelFactory @Inject constructor(
    private val viewModelReceiver : ViewModelReceiver
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModelReceiver as T
    }
}