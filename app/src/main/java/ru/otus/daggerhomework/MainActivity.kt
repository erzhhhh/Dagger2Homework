package ru.otus.daggerhomework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        val appComponent = App.getInstance()
        activityComponent = DaggerMainActivityComponent.factory()
            .getActivityComponent(context = this, applicationComponent = appComponent)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}