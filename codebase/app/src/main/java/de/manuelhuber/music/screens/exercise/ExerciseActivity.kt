package de.manuelhuber.music.screens.exercise

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import dagger.android.AndroidInjection
import de.manuelhuber.music.R
import de.manuelhuber.music.model.ExerciseFragment
import de.manuelhuber.music.screens.exercise.exercises.ExerciseWrapperFragment
import kotlinx.android.synthetic.main.content_exercise.*
import javax.inject.Inject

class ExerciseActivity : AppCompatActivity(), ExerciseContract.View {

    @Inject
    lateinit var presenter: ExerciseContract.Presenter

    fun nextExercise(@Suppress("UNUSED_PARAMETER") view: View) {
        presenter.nextExercise()
    }

    fun previousExercise(@Suppress("UNUSED_PARAMETER") view: View) {
        presenter.previousExercise()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        presenter.nextExercise()
    }

    override fun showExercise(exerciseFragment: ExerciseFragment, backward: Boolean) {
        val exitAnimation = if (backward) R.anim.exit_to_right else R.anim.exit_to_left
        val enterAnimation = if (backward) R.anim.enter_from_left else R.anim.enter_from_right
        val frag = ExerciseWrapperFragment()
        frag.setExercise(exerciseFragment)
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(enterAnimation, exitAnimation)
                .replace(
                        fragmentContainer.id,
                        frag
                ).commit()

    }
}
