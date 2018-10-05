package de.manuelhuber.music.screens.exercise

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import dagger.android.AndroidInjection
import de.manuelhuber.music.R
import de.manuelhuber.music.model.ExerciseFragment
import de.manuelhuber.music.screens.exercise.exercises.ExerciseWrapperFragment
import kotlinx.android.synthetic.main.content_exercise.*
import javax.inject.Inject

class ExerciseActivity : AppCompatActivity() {

    @Inject
    lateinit var model: ExerciseActivityModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        model.getCurrentExercise().observe(this, Observer { t ->
            if (null != t) {
                this.showExercise(t.first, t.second)
            }
        })
    }

    fun previousExercise(view: View) {
        model.previousExercise()
    }

    fun nextExercise(view: View) {
        model.nextExercise()
    }

    private fun showExercise(exerciseFragment: ExerciseFragment, backward: Boolean) {
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
