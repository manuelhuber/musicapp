package de.manuelhuber.music.screens.training.freeTraining

import android.os.Bundle
import dagger.android.AndroidInjection
import de.manuelhuber.music.R
import de.manuelhuber.music.screens.training.TrainingActivity
import javax.inject.Inject

@Suppress("UNUSED_PARAMETER")
class FreeTrainingActivity : TrainingActivity() {

    @Inject
    override lateinit var model: FreeTrainingModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_free_training)
    }


}
