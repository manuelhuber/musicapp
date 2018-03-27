package de.manuel_huber.music.model

import org.junit.Assert.*
import org.junit.Test

class FingerTest {
    @Test
    fun doesEqual() {
        val one = Finger(FingerPosition.Index, Hand.Right)
        val two = Finger(FingerPosition.Index, Hand.Right)
        assertTrue(one == one)
        assertTrue(one == two)
    }

    @Test
    fun doesNotEqual() {
        val one = Finger(FingerPosition.Index, Hand.Right)
        val two = Finger(FingerPosition.Index, Hand.Left)
        assertFalse(one == two)
    }

    @Test
    fun compare() {
        val first = Finger(FingerPosition.Pinky, Hand.Left)
        val second = Finger(FingerPosition.Thumb, Hand.Left)
        val anotherSecond = Finger(FingerPosition.Thumb, Hand.Left)
        val third = Finger(FingerPosition.Thumb, Hand.Right)
        val fourth = Finger(FingerPosition.Pinky, Hand.Right)

        assertTrue(Finger.compare(first, second) < 0)
        assertTrue(Finger.compare(second, third) < 0)
        assertTrue(Finger.compare(third, fourth) < 0)

        assertTrue(Finger.compare(anotherSecond, second) == 0)

        val unsortedList = listOf(second, fourth, third, first)

        assertEquals(
                unsortedList.sortedWith(Finger),
                listOf(first, second, third, fourth)
        )
    }

}