package de.manuelhuber.music.model

import de.manuelhuber.music.util.loopWithin
import de.manuelhuber.music.util.rndNumber
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
            // C
            0 -> (Pair(0, Sign.None))
            // C# Db
            1 -> if (decrease) Pair(1, Sign.Flat) else Pair(0, Sign.Sharp)
            // D
            2 -> (Pair(1, Sign.None))
            // D# Eb
            3 -> if (decrease) Pair(2, Sign.Flat) else Pair(1, Sign.Sharp)
            // E
            4 -> (Pair(2, Sign.None))
            // F
            5 -> (Pair(3, Sign.None))
            // F# Gb
            6 -> if (decrease) Pair(4, Sign.Flat) else Pair(3, Sign.Sharp)
            // G
            7 -> (Pair(4, Sign.None))
            // G# Ab
            8 -> if (decrease) Pair(5, Sign.Flat) else Pair(4, Sign.Sharp)
            // A
            9 -> (Pair(5, Sign.None))
            // A# Bb
            10 -> if (decrease) Pair(6, Sign.Flat) else Pair(5, Sign.Sharp)
            // B
            11 -> (Pair(6, Sign.None))
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
            0 -> "C"
            1 -> if (decrease) "Db" else "C#"
            2 -> "D"
            3 -> if (decrease) "Eb" else "D#"
            4 -> "E"
            5 -> "F"
            6 -> if (decrease) "Gb" else "F#"
            7 -> "G"
            8 -> if (decrease) "Ab" else "G#"
            9 -> "A"
            10 -> if (decrease) "Bb" else "A#"
            11 -> "B"
            else -> "Error"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Note

        return (decrease == other.decrease &&
                octave == other.octave &&
                note == other.note)
    }

    override fun hashCode(): Int {
        var result = decrease.hashCode()
        result = 31 * result + octave
        result = 31 * result + note
        return result
    }


}