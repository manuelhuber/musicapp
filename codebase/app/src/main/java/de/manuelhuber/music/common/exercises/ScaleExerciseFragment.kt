package de.manuelhuber.music.common.exercises


import de.manuelhuber.music.R
import de.manuelhuber.music.common.getRandomScale
import de.manuelhuber.music.model.IntervalSeries

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
