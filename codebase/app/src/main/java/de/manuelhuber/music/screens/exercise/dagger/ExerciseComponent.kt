package de.manuelhuber.music.screens.exercise.dagger

import dagger.Subcomponent
import dagger.android.AndroidInjector
import de.manuelhuber.music.dagger.ActivityScope
import de.manuelhuber.music.screens.exercise.core.ExerciseActivity


@ActivityScope
@Subcomponent(modules = [ExerciseModule::class])
interface ExerciseComponent : AndroidInjector<ExerciseActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ExerciseActivity>()
}