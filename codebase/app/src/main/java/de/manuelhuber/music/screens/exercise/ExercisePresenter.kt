package de.manuelhuber.music.screens.exercise

import de.manuelhuber.music.model.ExerciseFragment
import de.manuelhuber.music.screens.exercise.exercises.*

class ExercisePresenter(private val view: ExerciseContract.View) : ExerciseContract.Presenter {
    private var currentExercise = 0
    private val exercises: List<ExerciseFragment> = listOf(
            NoteReadingFragment.newInstance(),
            FingerControlExerciseFragment.newInstance(),
            IntervalExerciseFragment.newInstance(),
            ScaleExerciseFragment.newInstance(),
            AccordExerciseFragment.newInstance()
    )

    override fun nextExercise() {
        if (currentExercise == exercises.size - 1) return
        currentExercise++
        displayCurrentFragment(false)
    }

    override fun previousExercise() {
        if (currentExercise == 0) return
        currentExercise--
        displayCurrentFragment(true)
    }

    private fun displayCurrentFragment(backward: Boolean) {
        view.showExercise(exercises[currentExercise], backward)
    }
}