package de.manuel_huber.music.exercises

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuel_huber.music.R
import de.manuel_huber.music.note.NoteFragment
import kotlinx.android.synthetic.main.fragment_note_reading.*

class NoteReadingFragment : Fragment() {

    private lateinit var noteDisplay: NoteFragment
    private var showSolution = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_reading, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button3.setOnClickListener { click() }

        noteDisplay = NoteFragment.newInstance(0)
        childFragmentManager.beginTransaction()
                .add(noteFragment.id, noteDisplay)
                .commit()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun click() {
        if (showSolution) {
            button3.text = noteDisplay.note.toString()
        } else {
            noteDisplay.note = noteDisplay.note.steps(1)
            button3.text = resources.getString(R.string.show_solution)
        }
        showSolution = !showSolution
    }

    companion object {
        fun newInstance(): NoteReadingFragment {
            return NoteReadingFragment()
        }
    }
}
