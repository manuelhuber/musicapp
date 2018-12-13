package de.manuelhuber.music.screens.timedTraining

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.CountDownTimer
import de.manuelhuber.music.common.exercises.ExerciseFragment
import de.manuelhuber.music.model.technical.BaseViewModel
import de.manuelhuber.music.service.TrainingsService
import de.manuelhuber.music.util.then

class TimedTrainingActivityModel(trainingService: TrainingsService) : BaseViewModel() {

    val durationData = trainingService.timedExerciseDuration

    private var exerciseIndex = -1

    private val currentExercise: MutableLiveData<ExerciseFragment> by lazy {
        MutableLiveData<ExerciseFragment>()
    }
    private val progress: MutableLiveData<Pair<Int, Int>> = MutableLiveData()
    private val popup: MutableLiveData<PopupTO?> = MutableLiveData()

    private var exercises: List<ExerciseFragment> = listOf()

    init {
        trainingService.activeExercises().subscribe { t ->
            exercises = t
            exerciseIndex = -1
            nextExercise()
        }.then(::disposeAtTheEnd)
        popup.value = PopupTO("Ready?", "Click to start", "Go") {
            this.start()
            popup.value = null
        }
    }

    fun start() {
        val duration = durationData.value!!
        val dur = duration * 1000L
        object : CountDownTimer(dur, 1000L) {

            override fun onTick(millisUntilFinished: Long) {
                val secondUntilFinished = (millisUntilFinished / 1000L).toInt()
                progress.value = Pair(duration - secondUntilFinished, secondUntilFinished)
            }

            override fun onFinish() {
                if (nextExercise()) {
                    start()
                } else {
                    end()
                }
            }
        }.start()
    }


    private fun end() {
        popup.value = PopupTO("Well done!", "Bottom text", "Again?")
        {
            exerciseIndex = 0
            start()
        }
    }

    private fun backToMain() {
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

    fun nextExercise(): Boolean {
        exerciseIndex++
        if (exerciseIndex < 0 || exerciseIndex >= exercises.size) return false
        currentExercise.value = exercises[exerciseIndex]
        return true
    }

    class PopupTO(
            val title: String,
            val message: String,
            val buttonText: String,
            val callback: () -> Unit
    )
}