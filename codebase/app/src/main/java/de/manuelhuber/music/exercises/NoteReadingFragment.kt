package de.manuelhuber.music.exercises

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuelhuber.music.R
import de.manuelhuber.music.model.Note
import de.manuelhuber.music.note.NoteFragment
import de.manuelhuber.music.util.rndBool
import kotlinx.android.synthetic.main.fragment_note_reading.*

/**
 * The reading notes exercise
 */
class NoteReadingFragment : Fragment() {

    private lateinit var noteFragment: NoteFragment
    private var showSolution = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_note_reading, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        exerciseButton.setOnClickListener { click() }
        noteFragment = NoteFragment.newInstance(Note())
        childFragmentManager.beginTransaction()
                .add(noteFragment.id, noteFragment)
                .commit()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun click() {
        if (showSolution) {
            exerciseButton.text = noteFragment.note.toString()
        } else {
            val note = Note()
            note.decrease = rndBool()
            note.octave = if (rndBool()) 0 else -1
            noteFragment.note = note
            exerciseButton.text = resources.getString(R.string.show_solution)
        }
        showSolution = !showSolution
    }

    companion object {
        fun newInstance(): NoteReadingFragment {
            return NoteReadingFragment()
        }
    }
}
