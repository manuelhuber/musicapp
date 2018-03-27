package de.manuel_huber.music.model

import de.manuel_huber.music.util.getRandomElement

enum class Hand {
    Left,
    Right;

    companion object {
        private val values = Hand.values()
        fun randomHand(): Hand {
            return values.getRandomElement()
        }
    }
}