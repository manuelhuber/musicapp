package de.manuel_huber.music.exercises


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuel_huber.music.R
import de.manuel_huber.music.model.Intervalls
import de.manuel_huber.music.resources.getRandomScale
import kotlinx.android.synthetic.main.fragment_scales.*

class ScalesFragment : Fragment() {

    private var state = -1
    private lateinit var scale: Intervalls

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scales, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutScalesCenter.setOnClickListener { click() }
        click()
    }

    fun click() {
        when (state) {
            0 -> {
                textSteps.text = scale.steps.joinToString("-")
                state++
            }
            1 -> {
                textScale.text = scale.toString()
                state++
            }
            else -> {
                textSteps.text = ""
                textScale.text = ""
                newScale()
                textNote.text = resources.getString(R.string.accord_composite, scale.startingNote, scale.nameId)
                state = 0
            }
        }
    }

    fun newScale() {
        scale = getRandomScale(resources, context!!);
    }

    companion object {
        fun newInstance(): ScalesFragment {
            return ScalesFragment()
        }
    }
}