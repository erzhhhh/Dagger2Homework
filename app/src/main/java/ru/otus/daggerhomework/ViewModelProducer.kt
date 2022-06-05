package ru.otus.daggerhomework

import android.content.Context
import android.graphics.Color
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class ViewModelProducer @Inject constructor(
    private val colorGenerator: ColorGenerator,
    private val eventManager: EventManager,
    @Named("mainActivityContext")
    private val context: Context
) : ViewModel() {

    fun generateColor() {
        if (context !is FragmentActivity) throw RuntimeException("Здесь нужен контекст активити")
        Toast.makeText(context, "Color sent", Toast.LENGTH_LONG).show()

        eventManager.set(colorGenerator.generateColor())
    }
}