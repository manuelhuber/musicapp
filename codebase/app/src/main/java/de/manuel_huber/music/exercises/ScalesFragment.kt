package de.manuel_huber.music.exercises


import de.manuel_huber.music.R
import de.manuel_huber.music.model.IntervalSeries
import de.manuel_huber.music.resources.getRandomScale

class ScalesFragment : IntervalSeriesExerciseFragment() {
    override val title: Int
        get() = R.string.scales_title
    override val description: Int
        get() = R.string.scales_explanation

    override fun nextInterval(): IntervalSeries {
        return getRandomScale(resources, context!!)
    }

    companion object {
        fun newInstance(): ScalesFragment {
            return ScalesFragment()
        }

    }
}
