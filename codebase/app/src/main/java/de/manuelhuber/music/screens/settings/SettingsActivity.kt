package de.manuelhuber.music.screens.settings

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import dagger.android.AndroidInjection
import de.manuelhuber.music.R

import kotlinx.android.synthetic.main.activity_settings.*
import javax.inject.Inject

class SettingsActivity : AppCompatActivity(), SettingsContract.View {

    @Inject
    lateinit var presenter: SettingsContract.Presenter

    fun exerciseManagementClicked(view: View) {
        presenter.openExerciseManagement()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setSupportActionBar(toolbar)
    }

    override fun openActivity(activity: Class<out Activity>) {
        val intent = Intent(this, activity).apply { }
        startActivity(intent)
    }
}
