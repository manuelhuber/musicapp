package de.manuelhuber.music.model

import android.support.v4.app.Fragment


abstract class ExerciseFragment : Fragment() {
    /**
     * The ID of the string resource for the title
     */
    abstract val title: Int
}