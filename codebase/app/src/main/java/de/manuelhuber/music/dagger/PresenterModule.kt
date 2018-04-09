package de.manuelhuber.music.dagger

import dagger.Module
import dagger.Provides
import de.manuelhuber.music.ui.exercise.ExerciseContract
import de.manuelhuber.music.ui.exercise.ExercisePresenter

@Module
class PresenterModule {
    @Provides
    fun provideExercisePresenter(view: ExerciseContract.View): ExerciseContract.Presenter =
            ExercisePresenter(view)
}