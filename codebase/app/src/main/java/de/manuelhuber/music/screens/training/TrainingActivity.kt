package de.manuelhuber.music.screens.training

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import de.manuelhuber.music.R
import de.manuelhuber.music.common.exercises.ExerciseFragment
import de.manuelhuber.music.common.exercises.ExerciseWrapperFragment
import kotlinx.android.synthetic.main.content_free_training.*

abstract class TrainingActivity : AppCompatActivity() {

    abstract val model: TrainingsModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model.getCurrentExercise().observe(this, Observer { t ->
            if (null != t) {
                this.showExercise(t.first, t.second)
            }
        })

        model.getShowNextButton().observe(this,
                Observer { t -> nextButton.visibility = if (t!!) View.VISIBLE else View.GONE })

        model.getShowPreviousButton().observe(this,
                Observer { t -> previousButton.visibility = if (t!!) View.VISIBLE else View.GONE })
    }

    fun previousExercise(view: View) {
        model.previousExercise()
    }

    fun nextExercise(view: View) {
        model.nextExercise()
    }

    protected fun showExercise(exerciseFragment: ExerciseFragment, backward: Boolean) {
        val exitAnimation = if (backward) R.anim.exit_to_right else R.anim.exit_to_left
        val enterAnimation = if (backward) R.anim.enter_from_left else R.anim.enter_from_right
        val frag = ExerciseWrapperFragment()
        frag.setExercise(exerciseFragment)
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(enterAnimation, exitAnimation)
                .replace(
                        timedFragmentContainer.id,
                        frag
                ).commit()

    }
}