package de.manuel_huber.music.exercises


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuel_huber.music.R
import de.manuel_huber.music.model.Intervalls
import de.manuel_huber.music.resources.getRandomAccord
import kotlinx.android.synthetic.main.fragment_accords.*

class AccordsFragment : Fragment() {

    private var state = -1
    private lateinit var accord: Intervalls

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_accords, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutAccordsCenter.setOnClickListener { click() }
        click()
    }

    fun click() {
        when (state) {
            0 -> {
                textSteps.text = accord.steps.joinToString("-")
                state++
            }
            1 -> {
                textAccord.text = accord.toString()
                state++
            }
            else -> {
                textSteps.text = ""
                textAccord.text = ""
                newAccord()
                textNote.text = resources.getString(R.string.accord_composite, accord.startingNote, accord.nameId)
                state = 0
            }
        }
    }

    fun newAccord() {
        accord = getRandomAccord(resources, context!!)
    }

    companion object {
        fun newInstance(): AccordsFragment {
            return AccordsFragment()
        }
    }
}