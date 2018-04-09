package de.manuelhuber.music.ui.exercise

import de.manuelhuber.music.model.ExerciseFragment

class ExerciseContract {
    interface View {
        fun showExercise(exerciseFragment: ExerciseFragment)
    }

    interface Presenter {
        fun nextExercise()
        fun previousExercise()
    }
}