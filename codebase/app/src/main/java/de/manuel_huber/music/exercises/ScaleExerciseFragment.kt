package de.manuel_huber.music.exercises


import de.manuel_huber.music.R
import de.manuel_huber.music.model.IntervalSeries
import de.manuel_huber.music.resources.getRandomScale

class ScaleExerciseFragment : IntervalSeriesExerciseFragment() {
    override val title = R.string.scales_title
    override val description = R.string.scales_explanation

    override fun nextInterval(): IntervalSeries {
        return getRandomScale(resources, context!!)
    }

    companion object {
        fun newInstance(): ScaleExerciseFragment {
            return ScaleExerciseFragment()
        }

    }
}
