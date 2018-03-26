package de.manuel_huber.music.note


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import de.manuel_huber.music.R
import de.manuel_huber.music.model.Note
import de.manuel_huber.music.model.Sign
import kotlinx.android.synthetic.main.fragment_note.*

/**
 * A simple [Fragment] subclass.
 * Use the [NoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoteFragment : Fragment() {

    var note: Note = Note()
        set(value) {
            field = value
            update()
        }

    private lateinit var marginParams: MarginLayoutParams
    private var density: Float = 0.0f
    private var update = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            note = Note(arguments!!.getInt(ARG_NOTE))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        marginParams = noteImage.layoutParams as MarginLayoutParams
        density = context?.resources?.displayMetrics?.densityDpi!!.toFloat()
        if (update) update()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    private fun update() {
        if (!this::marginParams.isInitialized) {
            update = true
            return
        }
        val position = note.positionOnStaff()[0]
        sharpImage.visibility = if (position.second == Sign.Sharp) View.VISIBLE else View.INVISIBLE
        flatImage.visibility = if (position.second == Sign.Flat) View.VISIBLE else View.INVISIBLE
        val octaveMod = if (Math.random() < 0.5) 0 else 0
        val positionDelta = position.first + octaveMod
        marginParams.topMargin = Math.ceil((POSITION_OF_A_DP - positionDelta * NOTE_DISTANCE_DP) *
                (density / DisplayMetrics.DENSITY_DEFAULT)).toInt()
        noteImage.layoutParams = marginParams
    }

    companion object {
        private const val ARG_NOTE = "note"
        private const val NOTE_DISTANCE_DP = 12
        private const val POSITION_OF_A_DP = 126.25
        fun newInstance(note: Int): NoteFragment {
            val fragment = NoteFragment()
            val args = Bundle()
            args.putInt(ARG_NOTE, note)
            fragment.arguments = args
            return fragment
        }
    }

}
