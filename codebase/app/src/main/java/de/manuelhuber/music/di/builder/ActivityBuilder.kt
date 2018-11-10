package de.manuelhuber.music.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.manuelhuber.music.screens.freeTraining.FreeTrainingActivity
import de.manuelhuber.music.screens.exerciseManagement.ExerciseManagementActivity
import de.manuelhuber.music.screens.settings.SettingsActivity


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindExerciseActivity(): FreeTrainingActivity

    @ContributesAndroidInjector
    abstract fun bindSettingsActivity(): SettingsActivity

    @ContributesAndroidInjector
    abstract fun bindExerciseManagementActivity(): ExerciseManagementActivity

}