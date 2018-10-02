package de.manuelhuber.music

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import de.manuelhuber.music.screens.exercise.ExerciseActivity
import de.manuelhuber.music.screens.settings.SettingsActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startExercise(view: View) {
        val intent = Intent(this, ExerciseActivity::class.java).apply { }
        startActivity(intent)
    }

    fun openSettings(view: View) {
        val intent = Intent(this, SettingsActivity::class.java).apply { }
        startActivity(intent)
    }
}
