package de.manuelhuber.music.screens.exerciseManagement

import de.manuelhuber.music.common.exercises.ExerciseFragment
import de.manuelhuber.music.model.technical.BaseViewModel
import de.manuelhuber.music.service.TrainingsService

class ExerciseManagementActivityModel(private val trainingService: TrainingsService) : BaseViewModel() {

    var duration: String = trainingService.timedExerciseDuration.value.toString()
        set(value) {
            trainingService.timedExerciseDuration.value = value.toInt()
            field = value
        }

    fun exercises(): List<Pair<ExerciseFragment, Boolean>> {
        return trainingService.allExercises().toList()
    }

    fun toggleExercise(fragment: ExerciseFragment, active: Boolean) {
        trainingService.toggleExercise(fragment, active)
    }

}
