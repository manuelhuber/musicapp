package de.manuelhuber.music.dagger

import dagger.Component
import de.manuelhuber.music.application.MusicApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class])
interface AppComponent {
    fun inject(target: MusicApplication)
}