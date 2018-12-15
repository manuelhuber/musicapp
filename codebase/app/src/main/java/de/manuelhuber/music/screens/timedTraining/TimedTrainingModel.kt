package de.manuelhuber.music.screens.timedTraining

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.CountDownTimer
import de.manuelhuber.music.common.exercises.ExerciseFragment
import de.manuelhuber.music.model.technical.BaseViewModel
import de.manuelhuber.music.service.TrainingsService
import de.manuelhuber.music.util.then

class TimedTrainingModel(trainingService: TrainingsService) : BaseViewModel() {

    val durationData = trainingService.timedExerciseDuration

    private var showNextButton: MutableLiveData<Boolean> = MutableLiveData()
    private var showPreviousButton: MutableLiveData<Boolean> = MutableLiveData()
    private var exerciseIndex = -1

    private val currentExercise: MutableLiveData<ExerciseFragment> by lazy {
        MutableLiveData<ExerciseFragment>()
    }
    private val progress: MutableLiveData<Pair<Int, Int>> = MutableLiveData()
    private val popup: MutableLiveData<PopupTO?> = MutableLiveData()

    private var exercises: List<ExerciseFragment> = listOf()
    private var timer: CountDownTimer? = null


    init {
        trainingService.activeExercises().subscribe { t ->
            exercises = t
            exerciseIndex = -1
            publishNextExercise()
        }.then(::disposeAtTheEnd)
        popup.value = PopupTO("Ready?", "Click to start", "Go") {
            this.startTimer()
            popup.value = null
        }
        updateButtons()
    }

    fun startTimer() {
        val duration = durationData.value!!
        val dur = duration * 1000L
        timer?.cancel()
        timer = object : CountDownTimer(dur, 1000L) {

            override fun onTick(millisUntilFinished: Long) {
                val secondUntilFinished = (millisUntilFinished / 1000L).toInt()
                progress.value = Pair(duration - secondUntilFinished, secondUntilFinished)
            }

            override fun onFinish() {
                if (publishNextExercise()) {
                    startTimer()
                } else {
                    end()
                }
            }
        }
        timer!!.start()
    }

    fun rewind() {
        startTimer()
    }

    fun pause() {
        if (timer != null) {
        }
    }

    fun nextExercise() {
        publishNextExercise()
        startTimer()
    }

    fun previousExercise() {
        publishPreviousExercise()
        startTimer()
    }

    fun end() {
        popup.value = PopupTO("Well done!", "Bottom text", "Again?")
        {
            exerciseIndex = 0
            startTimer()
        }
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

    fun getCurrentExercise(): LiveData<ExerciseFragment> {
        return currentExercise
    }

    fun getShowNextButton(): LiveData<Boolean> {
        return showNextButton
    }

    fun getShowPreviousButton(): LiveData<Boolean> {
        return showPreviousButton
    }

    private fun updateButtons() {
        showPreviousButton.value = exerciseIndex > 0
        showNextButton.value = exerciseIndex < exercises.size - 1
    }

    private fun publishNextExercise(): Boolean {
        exerciseIndex++
        return publishExercise()
    }

    private fun publishPreviousExercise(): Boolean {
        exerciseIndex--
        return publishExercise()
    }

    private fun publishExercise(): Boolean {
        if (exerciseIndex < 0 || exerciseIndex >= exercises.size) return false
        currentExercise.value = exercises[exerciseIndex]
        updateButtons()
        return true
    }

    class PopupTO(
            val title: String,
            val message: String,
            val buttonText: String,
            val callback: () -> Unit
    )
}