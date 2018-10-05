package de.manuelhuber.music.screens.exercise

import dagger.Module
import dagger.Provides


@Module
class ExerciseActivityModule {
    @Provides
    fun provideMainView(mainActivity: ExerciseActivity): ExerciseActivity = mainActivity
}