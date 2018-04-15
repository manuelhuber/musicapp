package de.manuelhuber.music.screens.exercise

import dagger.Module
import dagger.Provides


@Module
class ExerciseActivityModule {

    @Provides
    fun provideMainView(mainActivity: ExerciseActivity): ExerciseContract.View {
        return mainActivity
    }

    @Provides
    fun provideExercisePresenter(view: ExerciseContract.View): ExerciseContract.Presenter =
            ExercisePresenter(view)
}