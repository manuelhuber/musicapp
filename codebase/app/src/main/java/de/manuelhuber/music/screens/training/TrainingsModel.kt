package de.manuelhuber.music.screens.training

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import de.manuelhuber.music.common.exercises.ExerciseFragment
import de.manuelhuber.music.model.technical.BaseViewModel

abstract class TrainingsModel : BaseViewModel() {
    protected var exerciseIndex = -1
    protected var exercises: List<ExerciseFragment> = listOf()
    private var showNextButton: MutableLiveData<Boolean> = MutableLiveData()
    private var showPreviousButton: MutableLiveData<Boolean> = MutableLiveData()
    private val currentExercise: MutableLiveData<Pair<ExerciseFragment, Boolean>> by lazy {
        MutableLiveData<Pair<ExerciseFragment, Boolean>>()
    }

    fun getShowNextButton(): LiveData<Boolean> {
        return showNextButton
    }

    fun getShowPreviousButton(): LiveData<Boolean> {
        return showPreviousButton
    }

    open fun restart() {
        exerciseIndex = -1
        nextExercise()
    }

    open fun nextExercise(): Boolean {
        exerciseIndex++
        return displayCurrentFragment(false)
    }

    open fun previousExercise(): Boolean {
        exerciseIndex--
        return displayCurrentFragment(true)
    }

    protected fun updateButtons() {
        showPreviousButton.value = exerciseIndex > 0
        showNextButton.value = exerciseIndex < exercises.size - 1
    }

    private fun displayCurrentFragment(backward: Boolean): Boolean {
        updateButtons()
        if (exerciseIndex < 0 || exerciseIndex > exercises.size -1 ) return false
        currentExercise.value = Pair(exercises[exerciseIndex], backward)
        return true
    }

    fun getCurrentExercise(): LiveData<Pair<ExerciseFragment, Boolean>> {
        return currentExercise
    }
}