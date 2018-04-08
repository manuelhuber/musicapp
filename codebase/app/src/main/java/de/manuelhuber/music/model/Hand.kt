package de.manuelhuber.music.model

import de.manuelhuber.music.util.getRandomElement

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