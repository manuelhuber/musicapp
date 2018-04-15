package de.manuelhuber.music.screens.exercise.core

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import dagger.android.AndroidInjection
import de.manuelhuber.music.R
import de.manuelhuber.music.model.ExerciseFragment
import kotlinx.android.synthetic.main.content_exercise.*
import javax.inject.Inject

class ExerciseActivity : AppCompatActivity(), ExerciseContract.View {

    @Inject
    lateinit var presenter: ExerciseContract.Presenter

    fun nextExercise(view: View) {
        presenter.nextExercise()
    }

    fun previousExercise(view: View) {
        presenter.previousExercise()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        presenter.nextExercise()
    }

    override fun showExercise(exerciseFragment: ExerciseFragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(
                        fragment_container.id,
                        exerciseFragment
                ).commit()

    }
}
