package de.manuelhuber.music.exercise


import de.manuelhuber.music.R
import de.manuelhuber.music.model.IntervalSeries
import de.manuelhuber.music.resources.getRandomScale

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
