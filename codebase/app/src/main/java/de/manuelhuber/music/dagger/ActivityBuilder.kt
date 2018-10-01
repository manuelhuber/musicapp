package de.manuelhuber.music.dagger

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.manuelhuber.music.screens.exercise.ExerciseActivity
import de.manuelhuber.music.screens.exercise.ExerciseActivityModule


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [ExerciseActivityModule::class])
    abstract fun bindExerciseActivity(): ExerciseActivity

}