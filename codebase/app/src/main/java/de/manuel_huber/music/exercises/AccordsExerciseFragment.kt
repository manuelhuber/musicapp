package de.manuel_huber.music.exercises


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuel_huber.music.R
import de.manuel_huber.music.model.Intervals
import de.manuel_huber.music.resources.getRandomAccord
import kotlinx.android.synthetic.main.fragment_accords_exercise.*

/**
 * Displays the accord exercise.
 * Shows a note and an accord name, then the intervals of the accord and then the actual notes
 * Accords are chosen completely at random
 */
class AccordsExerciseFragment : Fragment() {

    private var next = NextShow.NOTE
    private lateinit var accord: Intervals

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_accords_exercise, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutExerciseButton.setOnClickListener { click() }
        showNote()
    }

    private fun click() {
        when (next) {
            NextShow.NOTE -> showNote()
            NextShow.INTERVAL -> showInterval()
            NextShow.SOLUTIONS -> showSolution()
        }
    }

    private fun showNote() {
        accord = getRandomAccord(resources, context!!)
        textExercise.text = resources.getString(R.string.accord_composite, accord.startingNote, accord.nameId)
        textSteps.text = ""
        textSolution.text = ""
        next = NextShow.INTERVAL
    }

    private fun showInterval() {
        textSteps.text = accord.steps.joinToString("-")
        next = NextShow.SOLUTIONS
    }

    private fun showSolution() {
        textSolution.text = accord.toString()
        next = NextShow.NOTE
    }

    companion object {
        fun newInstance(): AccordsExerciseFragment {
            return AccordsExerciseFragment()
        }
    }

    enum class NextShow {
        NOTE,
        INTERVAL,
        SOLUTIONS
    }
}