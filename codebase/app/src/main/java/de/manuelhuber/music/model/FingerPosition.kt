package de.manuelhuber.music.model

import de.manuelhuber.music.util.getRandomElement

enum class FingerPosition {
    Thumb,
    Index,
    Middle,
    Ring,
    Pinky;

    companion object {
        private val values = FingerPosition.values()
        fun randomSingleFinger(): FingerPosition {
            return values.getRandomElement()
        }
    }
}