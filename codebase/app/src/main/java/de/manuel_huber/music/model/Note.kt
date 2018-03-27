package de.manuel_huber.music.model

import de.manuel_huber.music.util.loopWithin
import de.manuel_huber.music.util.rndNumber
import java.io.Serializable

class Note(note: Int = rndNumber(0, 11), var decrease: Boolean = false, var octave: Int = 0) : Serializable {

    var note = note
        set(value) {
            field = loopWithin(0, 11, value)
        }

    fun steps(steps: Int): Note {
        return Note(loopWithin(0, 11, steps + note))
    }

    fun positionOnStaff(): Pair<Int, Sign> {
        val pair = when (note) {
            0 -> (Pair(0, Sign.None))
            1 -> if (decrease) Pair(1, Sign.Flat) else Pair(0, Sign.Sharp)
            2 -> (Pair(1, Sign.None))
            3 -> (Pair(2, Sign.None))
            4 -> if (decrease) Pair(3, Sign.Flat) else Pair(2, Sign.Sharp)
            5 -> (Pair(3, Sign.None))
            6 -> if (decrease) Pair(4, Sign.Flat) else Pair(3, Sign.Sharp)
            7 -> (Pair(4, Sign.None))
            8 -> (Pair(5, Sign.None))
            9 -> if (decrease) Pair(6, Sign.Flat) else Pair(5, Sign.Sharp)
            10 -> (Pair(6, Sign.None))
            11 -> if (decrease) Pair(0, Sign.Flat) else Pair(6, Sign.Sharp)
            else -> throw Error("Note")
        }
        return pair.copy(pair.first + octave * 7)
    }

    override fun toString(): String {
        return noteToString()
    }

    private fun noteToString(): String {
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