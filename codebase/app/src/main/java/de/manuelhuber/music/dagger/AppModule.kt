package de.manuelhuber.music.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import de.manuelhuber.music.screens.exercise.dagger.ExerciseComponent
import javax.inject.Singleton

@Module(subcomponents = [
    ExerciseComponent::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: Application): Context {
        return app
    }
}