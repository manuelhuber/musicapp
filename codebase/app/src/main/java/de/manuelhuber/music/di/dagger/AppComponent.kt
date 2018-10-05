package de.manuelhuber.music.di.dagger

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import de.manuelhuber.music.di.builder.ActivityBuilder
import de.manuelhuber.music.di.builder.ServiceBuilder
import de.manuelhuber.music.di.builder.ViewModelBuilder
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