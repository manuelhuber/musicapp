package de.manuelhuber.music.util

import org.junit.Assert.assertEquals
import org.junit.Test

class UtilKtTest {
    @Test
    fun loopWithinWithin() {
        assertEquals(11, loopWithin(0, 12, 11))
        assertEquals(12, loopWithin(0, 12, 12))
        assertEquals(0, loopWithin(0, 12, 0))
    }

    @Test
    fun loopWithinOver() {
        assertEquals(0, loopWithin(0, 12, 13))
        assertEquals(1, loopWithin(1, 12, 13))
        assertEquals(1, loopWithin(1, 12, 25))
        assertEquals(1, loopWithin(0, 12, 14))
        assertEquals(11, loopWithin(11, 12, 15))
    }

    @Test
    fun loopWithinUnder() {
        assertEquals(12, loopWithin(0, 12, -1))
        assertEquals(12, loopWithin(1, 12, 0))
        assertEquals(11, loopWithin(0, 12, -2))
        assertEquals(0, loopWithin(0, 11, -12))

        assertEquals(12, loopWithin(11, 12, 10))
        assertEquals(12, loopWithin(11, 12, 8))
        assertEquals(11, loopWithin(11, 12, 7))
    }

}