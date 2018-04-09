package de.manuelhuber.music.ui.exercise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import de.manuelhuber.music.R
import de.manuelhuber.music.application.MusicApplication
import de.manuelhuber.music.model.ExerciseFragment
import de.manuelhuber.music.ui.exercise.DI.DaggerExerciseComponent
import de.manuelhuber.music.ui.exercise.DI.ExerciseModule
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
        val app = (applicationContext as MusicApplication).musicComponent
        DaggerExerciseComponent.builder()
                .appComponent(app)
                .exerciseModule(ExerciseModule(this))
                .build()
                .inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
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
