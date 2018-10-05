package de.manuelhuber.music.screens.exercise

import dagger.Module
import dagger.Provides
import de.manuelhuber.music.service.TrainingsService


@Module
class ExerciseActivityModule {

    @Provides
    fun provideMainView(mainActivity: ExerciseActivity): ExerciseActivity = mainActivity

    @Provides
    fun provideViewModel(trainingService: TrainingsService): ExerciseActivityModel =
            ExerciseActivityModel(trainingService)
}