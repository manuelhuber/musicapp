package de.manuelhuber.music.application

import android.app.Application
import de.manuelhuber.music.dagger.AppComponent
import de.manuelhuber.music.dagger.AppModule
import de.manuelhuber.music.dagger.DaggerAppComponent

class MusicApplication : Application() {

    val musicComponent : AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        musicComponent.inject(this)
    }

}