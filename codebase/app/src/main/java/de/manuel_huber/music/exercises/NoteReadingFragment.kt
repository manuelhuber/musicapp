package de.manuel_huber.music.exercises

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuel_huber.music.R

class NoteReadingFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_reading, container, false)
    }

    companion object {
        fun newInstance(): NoteReadingFragment {
            val fragment = NoteReadingFragment()
            return fragment
        }
    }
}// Required empty public constructor
