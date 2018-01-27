package de.manuel_huber.music

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import de.manuel_huber.music.exercises.FingerControl
import de.manuel_huber.music.exercises.Intervals
import kotlinx.android.synthetic.main.content_exercise.*

class Exercise : AppCompatActivity() {

    val exercises: List<Fragment> = listOf(FingerControl(), Intervals())
    var currentExercise: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        displayCurrentFragment()
    }

    fun nextExercise(view: View) {
        if (currentExercise == exercises.size - 1) return
        currentExercise++
        displayCurrentFragment()
    }

    fun previousExercise(view: View) {
        if (currentExercise == 0) return
        currentExercise--
        displayCurrentFragment()
    }

    private fun displayCurrentFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(
                        fragment_container.id,
                        exercises.get(currentExercise)
                ).commit()

    }
}
