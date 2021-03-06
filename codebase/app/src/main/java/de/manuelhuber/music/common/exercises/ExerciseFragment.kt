package de.manuelhuber.music.common.exercises

import android.support.v4.app.Fragment


abstract class ExerciseFragment : Fragment() {
    /**
     * The ID of the string resource for the title
     */
    abstract val title: Int
    /**
     * The ID of the string resource for the description
     */
    abstract val description: Int
}