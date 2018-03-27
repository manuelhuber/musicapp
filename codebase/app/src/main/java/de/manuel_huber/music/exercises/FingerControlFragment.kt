package de.manuel_huber.music.exercises

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuel_huber.music.R
import de.manuel_huber.music.model.Finger
import de.manuel_huber.music.util.rndNumber
import kotlinx.android.synthetic.main.fragment_finger_control.*

class FingerControlFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_finger_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonFingerControl.setOnClickListener { getFingerString() }
        getFingerString()
    }

    private fun getFingerString() {
        buttonFingerControl.text = getExercise()
    }

    private fun getExercise(): String {
        val fingers: MutableCollection<Finger> = mutableListOf()
        val max: Int = this.getNumberOfFingers()
        while (fingers.size < max && fingers.size < 10) {
            // Constructor creates a random finger
            val potentialFinger = Finger()
            // Add the finger if its not in the array already
            if (!fingers.any { finger -> finger == potentialFinger }) {
                fingers.add(potentialFinger)
            }
        }
        return fingers.sortedWith(Finger)
                .joinToString("-") { finger -> finger.toString() }
    }

    private fun getNumberOfFingers(): Int {
        return rndNumber(1, 5)
    }


    companion object {
        fun newInstance(): FingerControlFragment {
            return FingerControlFragment()
        }
    }
}