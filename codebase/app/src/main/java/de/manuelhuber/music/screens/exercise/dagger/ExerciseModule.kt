package de.manuelhuber.music.screens.exercise.dagger

import dagger.Module
import dagger.Provides
import de.manuelhuber.music.screens.exercise.core.ExerciseContract
import de.manuelhuber.music.screens.exercise.core.ExercisePresenter


@Module
class ExerciseModule(private val view: ExerciseContract.View) {

    @Provides
    fun provideExercisePresenter(): ExerciseContract.Presenter =
            ExercisePresenter(view)
}