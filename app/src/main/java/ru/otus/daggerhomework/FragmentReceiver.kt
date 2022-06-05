package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import javax.inject.Inject
import javax.inject.Provider

class FragmentReceiver : Fragment() {

    @Inject
    lateinit var fragmentReceiverViewModelFactory: Provider<FragmentReceiverViewModelFactory>

    private val model: ViewModelReceiver by viewModels(factoryProducer = { fragmentReceiverViewModelFactory.get() })

    private lateinit var frame: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerFragmentReceiverComponent.factory()
            .createFragmentReceiverComponent((activity as MainActivity).activityComponent)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        model.observeColors().observe(viewLifecycleOwner) { count ->
            populateColor(count)
        }
    }

    private fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}