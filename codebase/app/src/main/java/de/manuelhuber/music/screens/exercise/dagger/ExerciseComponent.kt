package de.manuelhuber.music.screens.exercise.dagger

import dagger.Component
import de.manuelhuber.music.dagger.ActivityScope
import de.manuelhuber.music.dagger.AppComponent
import de.manuelhuber.music.screens.exercise.core.ExerciseActivity
import de.manuelhuber.music.screens.exercise.core.ExerciseContract.Presenter


@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ExerciseModule::class])
interface ExerciseComponent {

    val mainPresenter: Presenter
    fun inject(categoryActivity: ExerciseActivity)
}