package de.manuelhuber.music.dagger

import dagger.Module
import dagger.Provides
import de.manuelhuber.music.service.TrainingsService
import javax.inject.Singleton

@Module
class ServiceBuilder {

    @Provides
    @Singleton
    fun provideTrainingService(): TrainingsService {
        return TrainingsService()
    }
}