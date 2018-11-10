package de.manuelhuber.music.di.builder

import dagger.Module
import dagger.Provides
import de.manuelhuber.music.screens.freeTraining.FreeTrainingModel
import de.manuelhuber.music.screens.exerciseManagement.ExerciseManagementActivityModel
import de.manuelhuber.music.service.TrainingsService
import javax.inject.Singleton

@Module
class ViewModelBuilder {

    @Provides
    @Singleton
    fun provideExerciseActivityModel(trainingService: TrainingsService): FreeTrainingModel =
            FreeTrainingModel(trainingService)

    @Provides
    @Singleton
    fun provideExerciseManagementActivityModel(trainingService: TrainingsService): ExerciseManagementActivityModel =
            ExerciseManagementActivityModel(trainingService)
}