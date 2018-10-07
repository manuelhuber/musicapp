package de.manuelhuber.music.screens.exerciseManagement

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import de.manuelhuber.music.R
import kotlinx.android.synthetic.main.activity_exercise_management.*
import kotlinx.android.synthetic.main.content_exercise_management.*
import javax.inject.Inject

class ExerciseManagementActivity : AppCompatActivity() {

    @Inject
    lateinit var model: ExerciseManagementActivityModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_management)
        setSupportActionBar(toolbar)
        exerciseList.adapter = ExerciseListAdapter(applicationContext,
                R.layout.adapter_exercise_list,
                model::toggleExercise,
                model.exercises())
    }


}
