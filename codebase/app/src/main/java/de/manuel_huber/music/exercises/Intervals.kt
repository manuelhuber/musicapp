package de.manuel_huber.music.exercises

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuel_huber.music.R
import de.manuel_huber.music.model.Note
import de.manuel_huber.music.util.rndNumber
import kotlinx.android.synthetic.main.fragment_intervals.*

class Intervals : Fragment() {

    private var note = Note()
    private var step = rndNumber(-11, 11)

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onViewCreated(view, savedInstanceState)
        return inflater!!.inflate(R.layout.fragment_intervals, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textCurrentNote.text = note.toString()
        layoutIntervalCenter.setOnClickListener { newNote() }
        newNote()
    }

    private fun newNote() {
        note = note.steps(step)
        textCurrentNote.text = note.toString()
        updateButtons()
    }

    private fun updateButtons() {
        do step = rndNumber(-11, 11) while (step == 0)
        if (step > 0) {
            textStepsUp.text = step.toString()
            imageStepsUp.visibility = View.VISIBLE

            textStepsDown.text = ""
            imageStepsDown.visibility = View.INVISIBLE
        } else {
            textStepsDown.text = step.toString()
            imageStepsDown.visibility = View.VISIBLE

            textStepsUp.text = ""
            imageStepsUp.visibility = View.INVISIBLE
        }
    }
}