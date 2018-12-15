package de.manuelhuber.music.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.manuelhuber.music.screens.exerciseManagement.ExerciseManagementActivity
import de.manuelhuber.music.screens.training.freeTraining.FreeTrainingActivity
import de.manuelhuber.music.screens.settings.SettingsActivity
import de.manuelhuber.music.screens.training.timedTraining.TimedTrainingActivity


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindFreeTrainingActivity(): FreeTrainingActivity

    @ContributesAndroidInjector
    abstract fun bindTimedTrainingActivity(): TimedTrainingActivity

    @ContributesAndroidInjector
    abstract fun bindSettingsActivity(): SettingsActivity

    @ContributesAndroidInjector
    abstract fun bindExerciseManagementActivity(): ExerciseManagementActivity

}