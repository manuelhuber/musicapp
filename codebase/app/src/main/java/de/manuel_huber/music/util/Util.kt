package de.manuel_huber.music.util

import java.util.*

private val random = Random()

fun rndNumber(min: Int, max: Int): Int {
    return random.nextInt(max - min + 1) + min
}

fun rndBool(): Boolean {
    return random.nextBoolean()
}

/**
 * Maps the number to another number in the given range
 * Values that are higher than the maximum start at the minimum again.
 * max + 1 = min
 * max + 2 = min + 1
 * etc
 * Values below the minimum start again at the maximum
 * min - 1 = max
 * min - 2 = max - 1
 */
fun loopWithin(min: Int, max: Int, value: Int): Int {
    if (value in min..max) return value
    val range = (max - min + 1)
    return if (value > max) {
        min + (value - max - 1) % range
    } else {
        max - (min - value - 1) % range
    }
}

fun <E> List<E>.getRandomElement() = this[rndNumber(0, this.size)]
fun <E> Array<E>.getRandomElement() = this[rndNumber(0, this.size)]