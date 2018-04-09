package de.manuelhuber.music.ui.exercise.DI

import dagger.Module
import dagger.Provides
import de.manuelhuber.music.ui.exercise.ExerciseContract
import de.manuelhuber.music.ui.exercise.ExercisePresenter


@Module
class ExerciseModule(private val view: ExerciseContract.View) {

    @Provides
    fun provideExercisePresenter(): ExerciseContract.Presenter =
            ExercisePresenter(view)
}