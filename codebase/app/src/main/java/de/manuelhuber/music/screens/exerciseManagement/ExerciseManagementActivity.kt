package de.manuelhuber.music.screens.exerciseManagement

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import de.manuelhuber.music.R
import de.manuelhuber.music.databinding.ContentExerciseManagementBinding
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

        val binding = DataBindingUtil.setContentView<ContentExerciseManagementBinding>(
                this, R.layout.content_exercise_management)
        binding.model = model

        exerciseList.adapter = ExerciseListAdapter(applicationContext,
                R.layout.adapter_exercise_list,
                model::toggleExercise,
                model.exercises())
    }
}
