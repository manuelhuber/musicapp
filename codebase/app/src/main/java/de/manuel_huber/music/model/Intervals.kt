package de.manuel_huber.music.model

/**
 * A series of intervals which can represent an accord or a scale
 */
class Intervals(val nameId: String, val steps: IntArray, var startingNote: Note) {

    private fun getNotes(): List<Note> {
        return steps.fold(mutableListOf(startingNote))
        { acc: MutableList<Note>, steps: Int ->
            acc.add(acc.last().steps(steps))
            acc
        }
    }

    override fun toString(): String {
        return getNotes().joinToString("-") { note -> note.toString() }
    }
}