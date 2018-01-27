package de.manuel_huber.music.exercises

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import de.manuel_huber.music.R
import de.manuel_huber.music.model.Note
import de.manuel_huber.music.util.rndNumber

class Intervals : Fragment() {

    private var note = Note()
    private var step = rndNumber(-11, 11)

    private lateinit var stepDownText: TextView
    private lateinit var stepDownButton: Button

    private lateinit var stepUpText: TextView
    private lateinit var stepUpButton: Button

    private lateinit var currentNote: TextView

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_intervals, container, false)

        stepDownText = view.findViewById(R.id.text_steps_down)
        stepDownButton = view.findViewById(R.id.button_steps_down)
        stepUpText = view.findViewById(R.id.text_steps_up)
        stepUpButton = view.findViewById(R.id.button_steps_up)

        currentNote = view.findViewById(R.id.text_current_note)

        currentNote.text = note.toString()
        currentNote.setOnClickListener { newNote() }
        super.onViewCreated(view, savedInstanceState)

        newNote()

        return view
    }

    fun newNote() {
        note = note.steps(step)
        currentNote.text = note.toString()
        updateButtons()
    }

    fun updateButtons() {
        do step = rndNumber(-11, 11) while (step == 0)
        if (step > 0) {
            stepUpText.text = step.toString()
            stepDownText.text = ""
        } else {
            stepDownText.text = step.toString()
            stepUpText.text = ""

        }
    }
}