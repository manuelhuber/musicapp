package de.manuelhuber.music.exercises

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuelhuber.music.R
import de.manuelhuber.music.model.Finger
import de.manuelhuber.music.util.rndNumber
import kotlinx.android.synthetic.main.fragment_finger_control_exercise.*

/**
 * The finger control exercise
 * Shows a series of fingers which the user has to move
 */
class FingerControlExerciseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_finger_control_exercise, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonFingerControl.setOnClickListener { nextExercise() }
        nextExercise()
    }

    private fun nextExercise() {
        buttonFingerControl.text = getExercise()
    }

    /**
     * Generates a string of a random number of sorted fingers
     */
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

    /**
     * Random number between 1 and 5 (for now)
     */
    private fun getNumberOfFingers(): Int {
        return rndNumber(1, 5)
    }

    companion object {
        fun newInstance(): FingerControlExerciseFragment {
            return FingerControlExerciseFragment()
        }
    }
}