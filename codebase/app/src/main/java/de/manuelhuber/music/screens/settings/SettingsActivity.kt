package de.manuelhuber.music.screens.settings

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import de.manuelhuber.music.R
import de.manuelhuber.music.screens.exerciseManagement.ExerciseManagementActivity
import kotlinx.android.synthetic.main.activity_settings.*

@Suppress("UNUSED_PARAMETER")
class SettingsActivity : AppCompatActivity() {

    fun exerciseManagementClicked(view: View) {
        startActivity(Intent(this, ExerciseManagementActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setSupportActionBar(toolbar)
    }
}
