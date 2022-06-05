package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import javax.inject.Inject
import javax.inject.Provider

class FragmentProducer : Fragment() {

    @Inject
    lateinit var fragmentProducerViewModelFactory: Provider<FragmentProducerViewModelFactory>

    private val model: ViewModelProducer by viewModels(factoryProducer = { fragmentProducerViewModelFactory.get() })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerFragmentProducerComponent.factory()
            .createFragmentProducerComponent((activity as MainActivity).activityComponent)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
            model.generateColor()
        }
    }
}