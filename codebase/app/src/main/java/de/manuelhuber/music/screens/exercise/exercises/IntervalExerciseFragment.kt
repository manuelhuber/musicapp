package de.manuelhuber.music.screens.exercise.exercises

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuelhuber.music.R
import de.manuelhuber.music.model.ExerciseFragment
import de.manuelhuber.music.model.Note
import de.manuelhuber.music.util.rndNumber
import kotlinx.android.synthetic.main.fragment_interval_exercise.*

/**
 * The single interval exercise
 * Shows a note and an interval between 1 and 11 (up or down). The user has to figure out the
 * next note based on the interval.
 */
class IntervalExerciseFragment : ExerciseFragment() {
    override val title = R.string.intervals_title
    override val description = R.string.intervals_explanation

    private var note = Note()
    private var step = rndNumber(-11, 11)
    private var previousStep = 0

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_interval_exercise, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textCurrentNote.text = note.toString()
        layoutIntervalCenter.setOnClickListener { click() }
        click()
    }

    private fun click() {
        showSolution()
        generateNewExercise()
    }

    private fun showSolution() {
        note = note.steps(step)
        textCurrentNote.text = note.toString()
    }

    private fun generateNewExercise() {
        do step = rndNumber(-11, 11) while (step == 0 || step == -previousStep)
        previousStep = step
        val up = step > 0
        textStepsUp.text = if (up) step.toString() else ""
        imageStepsUp.visibility = if (up) View.VISIBLE else View.INVISIBLE
        textStepsDown.text = if (!up) step.toString() else ""
        imageStepsDown.visibility = if (!up) View.VISIBLE else View.INVISIBLE
    }

    companion object {
        fun newInstance(): IntervalExerciseFragment {
            return IntervalExerciseFragment()
        }
    }
}