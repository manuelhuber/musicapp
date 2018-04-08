package de.manuel_huber.music.exercises


import de.manuel_huber.music.R
import de.manuel_huber.music.model.IntervalSeries
import de.manuel_huber.music.resources.getRandomAccord

/**
 * Displays the accord exercise.
 * Shows a note and an accord name, then the intervals of the accord and then the actual notes
 * Accords are chosen completely at random
 */
class AccordsExerciseFragment : IntervalSeriesExerciseFragment() {
    override val title: Int
        get() = R.string.accords_title
    override val description: Int
        get() = R.string.accords_explanation

    override fun nextInterval(): IntervalSeries {
        return getRandomAccord(resources, context!!)
    }

    companion object {
        fun newInstance(): AccordsExerciseFragment {
            return AccordsExerciseFragment()
        }
    }

}