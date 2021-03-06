package de.manuelhuber.music.di.builder

import dagger.Module
import dagger.Provides
import de.manuelhuber.music.screens.exerciseManagement.ExerciseManagementActivityModel
import de.manuelhuber.music.screens.training.freeTraining.FreeTrainingModel
import de.manuelhuber.music.screens.training.timedTraining.TimedTrainingModel
import de.manuelhuber.music.service.TrainingsService
import javax.inject.Singleton

@Module
class ViewModelBuilder {

    @Provides
    @Singleton
    fun provideFreeTrainingModel(trainingService: TrainingsService): FreeTrainingModel =
            FreeTrainingModel(trainingService)

    @Provides
    @Singleton
    fun provideTimedTrainingActivityModel(trainingService: TrainingsService): TimedTrainingModel =
            TimedTrainingModel(trainingService)

    @Provides
    @Singleton
    fun provideExerciseManagementActivityModel(trainingService: TrainingsService): ExerciseManagementActivityModel =
            ExerciseManagementActivityModel(trainingService)
}