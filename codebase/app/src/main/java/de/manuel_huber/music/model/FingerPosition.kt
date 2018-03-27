package de.manuel_huber.music.model

import de.manuel_huber.music.util.rndNumber

enum class FingerPosition {
    Thumb,
    Index,
    Middle,
    Ring,
    Pinky;

    companion object {
        private val values = FingerPosition.values()
        fun randomSingleFinger(): FingerPosition {
            return values[rndNumber(0, values.size)]
        }
    }
}