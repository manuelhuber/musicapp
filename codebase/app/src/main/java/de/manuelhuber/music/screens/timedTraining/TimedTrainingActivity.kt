package de.manuelhuber.music.screens.timedTraining

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import de.manuelhuber.music.R
import de.manuelhuber.music.common.exercises.ExerciseFragment
import de.manuelhuber.music.common.exercises.ExerciseWrapperFragment
import de.manuelhuber.music.screens.timedTraining.TimedTrainingActivityModel.PopupTO
import kotlinx.android.synthetic.main.content_timed_training.*
import javax.inject.Inject


class TimedTrainingActivity : AppCompatActivity() {


    @Inject
    lateinit var model: TimedTrainingActivityModel

    private var popup: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timed_training)
        model.getCurrentExercise().observe(this, Observer { t ->
            if (null != t) {
                this.showExercise(t)
            }
        })
        timerBar.max = model.durationData.value!!
        model.getProgress().observe(this, Observer { value ->
            timerBar.progress = value!!.first
            timerText.text = value.second.toString()
        })
        model.getPopup().observe(this, Observer(::displayPopup))
    }

    override fun onDestroy() {
        super.onDestroy()
        popup?.dismiss()
    }

    private fun displayPopup(to: PopupTO?) {
        popup?.dismiss()
        if (to == null) return
        popup = AlertDialog.Builder(this)
                .setTitle(to.title)
                .setMessage(to.message)
                .setPositiveButton(to.buttonText) { _, _ -> to.callback() }
                .create()
        popup!!.show()

    }

    private fun showExercise(exerciseFragment: ExerciseFragment) {
        val frag = ExerciseWrapperFragment()
        frag.setExercise(exerciseFragment)
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left)
                .replace(
                        timedFragmentContainer.id,
                        frag
                ).commit()
    }
}
