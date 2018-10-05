package de.manuelhuber.music.screens.exercise

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import de.manuelhuber.music.model.ExerciseFragment
import de.manuelhuber.music.model.technical.BaseViewModel
import de.manuelhuber.music.service.TrainingsService
import de.manuelhuber.music.util.then
import javax.inject.Singleton

@Singleton
class ExerciseActivityModel(trainingService: TrainingsService) : BaseViewModel() {
    private var exerciseIndex = -1

    private val currentExercise: MutableLiveData<Pair<ExerciseFragment, Boolean>> by lazy {
        MutableLiveData<Pair<ExerciseFragment, Boolean>>()
    }
    private var exercises: List<ExerciseFragment> = listOf()

    init {
        println("Init view model")
        trainingService.activeExercises().subscribe { t ->
            exercises = t
            exerciseIndex = 0
            displayCurrentFragment(false)
        }.then(::disposeAtTheEnd)
    }

    fun getCurrentExercise(): LiveData<Pair<ExerciseFragment, Boolean>> {
        return currentExercise
    }

    fun nextExercise() {
        if (exerciseIndex == exercises.size - 1) return
        exerciseIndex++
        displayCurrentFragment(false)
    }

    fun previousExercise() {
        if (exerciseIndex == 0) return
        exerciseIndex--
        displayCurrentFragment(true)
    }

    private fun displayCurrentFragment(backward: Boolean) {
        if (exerciseIndex < 0 || exerciseIndex > exercises.size) return
        currentExercise.value = Pair(exercises[exerciseIndex], backward)
    }

}