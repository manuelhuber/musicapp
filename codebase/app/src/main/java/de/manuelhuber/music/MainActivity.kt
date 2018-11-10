package de.manuelhuber.music

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import de.manuelhuber.music.screens.freeTraining.FreeTrainingActivity
import de.manuelhuber.music.screens.settings.SettingsActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startExercise(view: View) {
        startActivity(Intent(this, FreeTrainingActivity::class.java))
    }

    fun openSettings(view: View) {
        startActivity(Intent(this, SettingsActivity::class.java))
    }
}
