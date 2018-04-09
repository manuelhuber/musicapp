package de.manuelhuber.music.dagger

import android.app.Application

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