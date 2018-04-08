package de.manuelhuber.music.exercises


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuelhuber.music.R
import de.manuelhuber.music.model.IntervalSeries
import kotlinx.android.synthetic.main.fragment_interval_series_exercise.*

/**
 * The exercise to train interval series (like accords or scales)
 * Shows a note and the interval series name, then the interval series in numbers and then the
 * actual notes
 */
abstract class IntervalSeriesExerciseFragment : Fragment() {

    private var next = NextShow.NOTE
    private lateinit var intervalSeries: IntervalSeries
    protected abstract val title: Int
    protected abstract val description: Int

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_interval_series_exercise, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutExerciseButton.setOnClickListener { click() }
        textTitle.text = resources.getString(title)
        titleDescription.text = resources.getString(description)
        showExercise()
    }

    private fun click() {
        when (next) {
            NextShow.NOTE -> showExercise()
            NextShow.INTERVAL -> showInterval()
            NextShow.SOLUTIONS -> showSolution()
        }
    }

    private fun showExercise() {
        intervalSeries = nextInterval()
        textExercise.text = resources.getString(
                R.string.interval_series_composite,
                intervalSeries.startingNote,
                intervalSeries.nameId)
        textSteps.text = ""
        textSolution.text = ""
        next = NextShow.INTERVAL
    }

    private fun showInterval() {
        textSteps.text = intervalSeries.steps.joinToString("-")
        next = NextShow.SOLUTIONS
    }

    private fun showSolution() {
        textSolution.text = intervalSeries.toString()
        next = NextShow.NOTE
    }

    protected abstract fun nextInterval(): IntervalSeries

    enum class NextShow { NOTE, INTERVAL, SOLUTIONS }
}