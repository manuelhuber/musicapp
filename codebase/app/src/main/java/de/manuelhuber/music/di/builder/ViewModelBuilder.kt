package de.manuelhuber.music.di.builder

import dagger.Module
import dagger.Provides
import de.manuelhuber.music.screens.exercise.ExerciseActivityModel
import de.manuelhuber.music.service.TrainingsService
import javax.inject.Singleton

@Module
class ViewModelBuilder {

    @Provides
    @Singleton
    fun provideViewModel(trainingService: TrainingsService): ExerciseActivityModel =
            ExerciseActivityModel(trainingService)
}