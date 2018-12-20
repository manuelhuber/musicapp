package de.manuelhuber.music.screens.training.timedTraining

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import dagger.android.AndroidInjection
import de.manuelhuber.music.R
import de.manuelhuber.music.screens.training.TrainingActivity
import de.manuelhuber.music.screens.training.timedTraining.TimedTrainingModel.PopupTO
import kotlinx.android.synthetic.main.content_timed_training.*
import javax.inject.Inject


@Suppress("UNUSED_PARAMETER")
class TimedTrainingActivity : TrainingActivity() {


    @Inject
    override lateinit var model: TimedTrainingModel

    private var popup: AlertDialog? = null

    fun rewind(view: View) {
        model.restartTime()
    }

    fun pause(view: View) {
        model.togglePause()
    }

    fun reset(view: View) {
        model.end()
    }

    override fun onPause() {
        super.onPause()
        model.pause()
    }

    override fun onStop() {
        super.onStop()
        model.pause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timed_training)
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

}
