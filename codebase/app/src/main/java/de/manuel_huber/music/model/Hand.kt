package de.manuel_huber.music.model

import de.manuel_huber.music.util.rndNumber

enum class Hand {
    Left,
    Right;

    companion object {
        private val values = Hand.values()
        fun randomHand(): Hand {
            return values[rndNumber(0, values.size)]
        }
    }
}