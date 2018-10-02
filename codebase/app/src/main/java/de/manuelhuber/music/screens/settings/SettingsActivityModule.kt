package de.manuelhuber.music.screens.settings

import dagger.Module
import dagger.Provides

@Module
class SettingsActivityModule {

    @Provides
    fun provideMainView(activity: SettingsActivity): SettingsContract.View {
        return activity
    }

    @Provides
    fun provideExercisePresenter(view: SettingsContract.View): SettingsContract.Presenter =
            SettingsPresenter(view)
}