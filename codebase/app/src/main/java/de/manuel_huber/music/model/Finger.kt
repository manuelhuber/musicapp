package de.manuel_huber.music.model

class Finger constructor(val finger: FingerPosition = FingerPosition.randomSingleFinger(),
                         val hand: Hand = Hand.randomHand()) {
    /**
     * Format: {{Hand}}{{Finger}}
     * Hand is either 'L' or 'R'
     * Finger is the number as defined in @FingerPosition plus 1 (since normal people don't like zero indexing)
     */
    override fun toString(): String {
        var s: String = if (this.hand == Hand.Left) "L" else "R"
        s += (this.finger.ordinal + 1)
        return s
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as Finger
        return that.finger == this.finger && that.hand == this.hand
    }

    override fun hashCode(): Int {
        return 31 * finger.ordinal + hand.ordinal
    }

    companion object : Comparator<Finger> {
        /**
         * Sort fingers from left to right just as they are when holding both hands straight out,
         * hand backside towards you. This means:
         * Left Pinky < Left Thumb < Right Thumb < Right Pinky
         */
        override fun compare(a: Finger, b: Finger): Int {
            return if (a.hand !== b.hand) {
                a.hand.compareTo(b.hand)
            } else {
                if (a.hand == Hand.Left) b.finger.compareTo(a.finger) else a.finger.compareTo(b.finger)
            }
        }
    }
}