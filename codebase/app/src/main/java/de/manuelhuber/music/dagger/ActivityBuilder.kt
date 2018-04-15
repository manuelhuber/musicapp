package de.manuelhuber.music.dagger

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import de.manuelhuber.music.screens.exercise.core.ExerciseActivity
import de.manuelhuber.music.screens.exercise.dagger.ExerciseComponent


@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(ExerciseActivity::class)
    abstract fun bindExerciseActivity(builder: ExerciseComponent.Builder): AndroidInjector.Factory<out Activity>


}