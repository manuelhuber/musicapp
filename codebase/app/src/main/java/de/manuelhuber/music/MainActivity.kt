package de.manuelhuber.music

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import de.manuelhuber.music.screens.exercise.ExerciseActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startExercise(view: View) {
        val intent = Intent(this, ExerciseActivity::class.java).apply { }
        startActivity(intent)
    }
}
