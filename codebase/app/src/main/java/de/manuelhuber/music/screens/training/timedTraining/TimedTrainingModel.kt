package de.manuelhuber.music.screens.training.timedTraining

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.CountDownTimer
import de.manuelhuber.music.screens.training.TrainingsModel
import de.manuelhuber.music.service.TrainingsService
import de.manuelhuber.music.util.then

class TimedTrainingModel(trainingService: TrainingsService) : TrainingsModel() {

    val durationData = trainingService.timedExerciseDuration

    private val progress: MutableLiveData<Pair<Int, Int>> = MutableLiveData()
    private val popup: MutableLiveData<PopupTO?> = MutableLiveData()
    private var timer: CountDownTimer? = null

    init {
        trainingService.activeExercises().subscribe { t ->
            exercises = t
            super.nextExercise()
        }.then(::disposeAtTheEnd)
        popup.value = PopupTO("Ready?", "Click to start", "Go") {
            this.startTimer()
            popup.value = null
        }
    }

    fun restartTime() {
        startTimer()
    }

    fun pause() {
        if (timer != null) {
            timer?.cancel()
            timer = null
        } else {
            startTimer(progress.value!!.second)
        }
    }

    override fun nextExercise(): Boolean {
        startTimer()
        return super.nextExercise()
    }

    override fun previousExercise(): Boolean {
        startTimer()
        return super.previousExercise()
    }

    fun end() {
        timer?.cancel()
        popup.value = PopupTO(
                "Well done!",
                "Bottom text",
                "Again?",
                this::restart)
    }

    /**
     * @return Pair<Seconds passed, Seconds remaining>
     */
    fun getProgress(): LiveData<Pair<Int, Int>> {
        return progress
    }

    /**
     * @return Pair<Seconds passed, Seconds remaining>
     */
    fun getPopup(): LiveData<PopupTO?> {
        return popup
    }

    private fun startTimer(resumeFrom: Int = -1) {
        val duration = durationData.value!!
        val dur = (if (resumeFrom > 0) resumeFrom else duration) * 1000L

        timer?.cancel()
        timer = object : CountDownTimer(dur, 1000L) {

            override fun onTick(millisUntilFinished: Long) {
                val secondUntilFinished = (millisUntilFinished / 1000L).toInt()
                progress.value = Pair(duration - secondUntilFinished, secondUntilFinished)
            }

            override fun onFinish() {
                if (!nextExercise()) {
                    end()
                }
            }
        }
        timer!!.start()
    }

    class PopupTO(
            val title: String,
            val message: String,
            val buttonText: String,
            val callback: () -> Unit
    )
}
