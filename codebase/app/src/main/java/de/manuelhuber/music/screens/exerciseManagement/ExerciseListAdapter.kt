package de.manuelhuber.music.screens.exerciseManagement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Switch
import android.widget.TextView
import de.manuelhuber.music.R
import de.manuelhuber.music.model.ExerciseFragment

/**
 * Displays a list of fragments and a toggle to (de)activate
 * @param objects A list of of fragments and their current active-status
 */
class ExerciseListAdapter(context: Context,
                          textViewResourceId: Int,
                          private val toggleCallback: (ExerciseFragment, Boolean) -> Unit,
                          private val objects: List<Pair<ExerciseFragment, Boolean>>)
    : ArrayAdapter<ExerciseFragment>(
        context,
        textViewResourceId,
        objects.map { pair -> pair.first }) {

    private var idMap: Map<ExerciseFragment, Int> = HashMap()

    init {
        idMap = objects.associate { pair -> Pair(pair.first, objects.indexOf(pair)) }
    }

    /**
     * Builds a view if there isn't one yet
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        if (convertView != null) return convertView

        val newView = LayoutInflater.from(context)
                .inflate(R.layout.adapter_exercise_list, parent, false)

        val active = newView.findViewById(R.id.exerciseToggle) as Switch
        val title = newView.findViewById(R.id.exerciseListText) as TextView

        active.isChecked = objects[position].second
        active.setOnCheckedChangeListener { _, isChecked ->
            toggleCallback(objects[position].first, isChecked)
        }
        title.text = context.resources.getString(objects[position].first.title)
        return newView
    }

    override fun getItemId(position: Int): Long {
        val item = getItem(position)
        return idMap[item!!]!!.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

}