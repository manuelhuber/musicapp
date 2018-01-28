package de.manuel_huber.music.model

class Intervalls(val nameId: String, val steps: IntArray, var startingNote: Note) {

    fun getNotes(): List<Note> {
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