package de.manuelhuber.music.screens.settings

import de.manuelhuber.music.screens.exerciseManagement.ExerciseManagementActivity

class SettingsPresenter(val view: SettingsContract.View) : SettingsContract.Presenter {

    override fun openExerciseManagement() {
        view.openActivity(ExerciseManagementActivity::class.java)
    }

}