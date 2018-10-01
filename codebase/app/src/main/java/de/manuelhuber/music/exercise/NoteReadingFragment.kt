package de.manuelhuber.music.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuelhuber.music.R
import de.manuelhuber.music.common.NoteFragment
import de.manuelhuber.music.model.ExerciseFragment
import de.manuelhuber.music.model.Note
import de.manuelhuber.music.util.rndBool
import kotlinx.android.synthetic.main.fragment_note_reading.*

/**
 * The reading notes exercise
 */
class NoteReadingFragment : ExerciseFragment() {
    override val title = R.string.note_reading_title

    private lateinit var noteDisplay: NoteFragment
    private var showSolution = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_note_reading, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        exerciseButton.setOnClickListener { click() }
        noteDisplay = NoteFragment.newInstance(Note())
        childFragmentManager.beginTransaction()
                .add(noteFragment.id, noteDisplay)
                .commit()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun click() {
        if (showSolution) {
            exerciseButton.text = noteDisplay.note.toString()
        } else {
            var note: Note
            do note = Note() while (note == noteDisplay.note)
            note.decrease = rndBool()
            note.octave = if (rndBool()) 0 else -1
            noteDisplay.note = note
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
