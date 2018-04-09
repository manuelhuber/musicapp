package de.manuelhuber.music.exercise


import de.manuelhuber.music.R
import de.manuelhuber.music.common.getRandomAccord
import de.manuelhuber.music.model.IntervalSeries

/**
 * The accord exercise
 * Shows a note and an accord name, then the intervals of the accord and then the actual notes
 * Accords are chosen completely at random
 */
class AccordExerciseFragment : IntervalSeriesExerciseFragment() {
    override val title = R.string.accords_title
    override val description = R.string.accords_explanation

    override fun nextInterval(): IntervalSeries {
        return getRandomAccord(resources, context!!)
    }

    companion object {
        fun newInstance(): AccordExerciseFragment {
            return AccordExerciseFragment()
        }
    }

}