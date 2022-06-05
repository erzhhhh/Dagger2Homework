package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Named

class ViewModelReceiver @Inject constructor(
    private val eventManager: EventManager,
    @Named("ApplicationContext")
    private val context: Context
) : ViewModel() {

    fun observeColors(): LiveData<Int> {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        Toast.makeText(context, "Color received", Toast.LENGTH_LONG).show()
        return eventManager.observe()
    }
}