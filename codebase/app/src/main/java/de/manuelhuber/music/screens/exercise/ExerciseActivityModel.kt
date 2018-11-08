package de.manuelhuber.music.screens.exercise

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import de.manuelhuber.music.model.ExerciseFragment
import de.manuelhuber.music.model.technical.BaseViewModel
import de.manuelhuber.music.service.TrainingsService
import de.manuelhuber.music.util.then

class ExerciseActivityModel(trainingService: TrainingsService) : BaseViewModel() {
    private var exerciseIndex = -1

    private val currentExercise: MutableLiveData<Pair<ExerciseFragment, Boolean>> by lazy {
        MutableLiveData<Pair<ExerciseFragment, Boolean>>()
    }
    private var exercises: List<ExerciseFragment> = listOf()
    private var showNextButton: MutableLiveData<Boolean> = MutableLiveData()
    private var showPreviousButton: MutableLiveData<Boolean> = MutableLiveData()

    init {
        trainingService.activeExercises().subscribe { t ->
            exercises = t
            exerciseIndex = 0
            displayCurrentFragment(false)
            updateButtons()
        }.then(::disposeAtTheEnd)
    }

    fun getCurrentExercise(): LiveData<Pair<ExerciseFragment, Boolean>> {
        return currentExercise
    }

    fun getShowNextButton(): LiveData<Boolean> {
        return showNextButton
    }

    fun getShowPreviousButton(): LiveData<Boolean> {
        return showPreviousButton
    }

    fun nextExercise() {
        exerciseIndex++
        updateButtons()
        displayCurrentFragment(false)
    }

    fun previousExercise() {
        exerciseIndex--
        updateButtons()
        displayCurrentFragment(true)
    }

    private fun updateButtons() {
        showPreviousButton.value = exerciseIndex > 0
        showNextButton.value = exerciseIndex < exercises.size - 1
    }

    private fun displayCurrentFragment(backward: Boolean) {
        if (exerciseIndex < 0 || exerciseIndex > exercises.size) return
        currentExercise.value = Pair(exercises[exerciseIndex], backward)
    }

}