package de.manuelhuber.music.screens.settings

import android.app.Activity

class SettingsContract {

    interface View {
        fun openActivity(activity: Class<out Activity>)
    }

    interface Presenter {
        fun openExerciseManagement()
    }
}