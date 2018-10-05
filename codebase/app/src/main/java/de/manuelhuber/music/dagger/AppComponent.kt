package de.manuelhuber.music.dagger

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class,
    ServiceBuilder::class,
    ViewModelBuilder::class])
interface AppComponent : AndroidInjector<MusicApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MusicApplication>()
}