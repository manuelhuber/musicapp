package de.manuel_huber.music.model

import de.manuel_huber.music.util.rndNumber

class Note(private var note: Int = rndNumber(0, 11)) {

    fun steps(steps: Int): Note {
        var newNote: Int = note + steps
        while (newNote < 0) newNote += 12;
        return Note(Math.abs(newNote) % 12)
    }

    override fun toString(): String {
        return noteToString()
    }

    private fun noteToString(decrease: Boolean = false): String {
        val saveNote: Int = Math.abs(note) % 12
        return when (saveNote) {
            0 -> "A"
            1 -> if (decrease) "Bb" else "A#"
            2 -> "B"
            3 -> "C"
            4 -> if (decrease) "Db" else "C#"
            5 -> "D"
            6 -> if (decrease) "Eb" else "D#"
            7 -> "E"
            8 -> "F"
            9 -> if (decrease) "Gb" else "F#"
            10 -> "G"
            11 -> if (decrease) "Ab" else "G#"
            else -> "Error"
        }
    }

}