package de.manuelhuber.music.screens.exercise

import de.manuelhuber.music.model.ExerciseFragment

class ExerciseContract {
    interface View {
        fun showExercise(exerciseFragment: ExerciseFragment, backward: Boolean)
    }

    interface Presenter {
        fun nextExercise()
        fun previousExercise()
    }
}