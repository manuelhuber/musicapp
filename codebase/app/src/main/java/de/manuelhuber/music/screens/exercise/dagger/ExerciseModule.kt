package de.manuelhuber.music.screens.exercise.dagger

import dagger.Module
import dagger.Provides
import de.manuelhuber.music.screens.exercise.core.ExerciseActivity
import de.manuelhuber.music.screens.exercise.core.ExerciseContract
import de.manuelhuber.music.screens.exercise.core.ExercisePresenter


@Module
class ExerciseModule {

    @Provides
    fun provideMainView(mainActivity: ExerciseActivity): ExerciseContract.View {
        return mainActivity
    }

    @Provides
    fun provideExercisePresenter(view: ExerciseContract.View): ExerciseContract.Presenter =
            ExercisePresenter(view)
}