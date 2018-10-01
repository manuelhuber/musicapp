package de.manuelhuber.music.dagger

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class MusicApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out MusicApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}