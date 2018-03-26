package de.manuel_huber.music.model

import de.manuel_huber.music.util.rndNumber

enum class Sign {
    None,
    Flat,
    Sharp
}

class Note(private var note: Int = rndNumber(0, 11)) {

    fun steps(steps: Int): Note {
        var newNote: Int = note + steps
        while (newNote < 0) newNote += 12;
        return Note(Math.abs(newNote) % 12)
    }

    fun positionOnStaff(): List<Pair<Int, Sign>> {
        return when (note) {
            0 -> listOf(Pair(0, Sign.None))
            1 -> listOf(Pair(0, Sign.Sharp), Pair(1, Sign.Flat))
            2 -> listOf(Pair(1, Sign.None))
            3 -> listOf(Pair(2, Sign.None))
            4 -> listOf(Pair(2, Sign.Sharp), Pair(3, Sign.Flat))
            5 -> listOf(Pair(3, Sign.None))
            6 -> listOf(Pair(3, Sign.Sharp), Pair(4, Sign.Flat))
            7 -> listOf(Pair(4, Sign.None))
            8 -> listOf(Pair(5, Sign.None))
            9 -> listOf(Pair(5, Sign.Sharp), Pair(6, Sign.Flat))
            10 -> listOf(Pair(6, Sign.None))
            11 -> listOf(Pair(6, Sign.Sharp), Pair(0, Sign.Flat))
            else -> listOf()
        }
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