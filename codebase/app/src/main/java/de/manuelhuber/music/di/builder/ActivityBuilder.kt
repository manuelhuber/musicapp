package de.manuelhuber.music.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.manuelhuber.music.screens.exercise.ExerciseActivity
import de.manuelhuber.music.screens.exerciseManagement.ExerciseManagementActivity
import de.manuelhuber.music.screens.settings.SettingsActivity
import de.manuelhuber.music.screens.settings.SettingsActivityModule


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindExerciseActivity(): ExerciseActivity

    @ContributesAndroidInjector(modules = [SettingsActivityModule::class])
    abstract fun bindSettingsActivity(): SettingsActivity

    @ContributesAndroidInjector
    abstract fun bindExerciseManagementActivity(): ExerciseManagementActivity

}