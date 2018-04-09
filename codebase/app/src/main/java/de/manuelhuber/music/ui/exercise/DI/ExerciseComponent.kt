package de.manuelhuber.music.ui.exercise.DI

import dagger.Component
import de.manuelhuber.music.dagger.ActivityScope
import de.manuelhuber.music.dagger.AppComponent
import de.manuelhuber.music.ui.exercise.ExerciseActivity
import de.manuelhuber.music.ui.exercise.ExerciseContract.Presenter


@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ExerciseModule::class])
interface ExerciseComponent {

    val mainPresenter: Presenter
    fun inject(categoryActivity: ExerciseActivity)
}