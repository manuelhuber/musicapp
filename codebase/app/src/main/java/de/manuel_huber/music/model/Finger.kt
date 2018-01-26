package de.manuel_huber.music.model

import de.manuel_huber.music.util.rndNumber

/**
 * Finger
 * 0 = thumb
 * 4 = pinky
 *
 * Hand
 * 0 = left
 * 1 = right
 */

class Finger constructor(val finger: Int = rndNumber(0, 4), val hand: Int = rndNumber(0, 1)) {
    /**
     * Format: {{Hand}}{{Finger}}
     * Hand is either 'L' or 'R'
     * Finger is the number as defined in the Finger class plus 1 (since normal people don't like zero indexing)
     */
    override fun toString(): String {
        var s: String = if (this.hand == 0) "L" else "R"
        s += (this.finger + 1)
        return s
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as Finger
        return that.finger == this.finger && that.hand == this.hand
    }

    override fun hashCode(): Int {
        var result = finger
        result = 31 * result + hand
        return result
    }

    companion object : Comparator<Finger> {
        /**
         * Sort fingers from left to right when holding them straight out, hand backside towards you.
         * Left Pinky < Left Thumb < Right Thumb < Right Pinky
         */
        override fun compare(a: Finger, b: Finger): Int {
            return if (a.hand < b.hand) {
                -1
            } else if (a.hand > b.hand) {
                1
            } else {
                if (a.hand == 0) b.finger - a.finger else a.finger - b.finger
            }
        }
    }
}