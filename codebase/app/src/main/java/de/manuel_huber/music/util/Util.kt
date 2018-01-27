package de.manuel_huber.music.util

import java.util.*

private val random = Random()

fun rndNumber(min: Int, max: Int): Int {
    return random.nextInt(max - min + 1) + min
}

fun <E> List<E>.getRandomElement() = this[random.nextInt(this.size)]