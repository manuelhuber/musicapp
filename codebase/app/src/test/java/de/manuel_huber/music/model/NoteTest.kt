package de.manuel_huber.music.model

import org.junit.Assert.assertEquals
import org.junit.Test

class NoteTest {

    @Test
    fun stepsUpATest() {
        val a = Note(0)
        assertEquals(a.toString(), "A")
        assertEquals("A", a.steps(12).toString())
        assertEquals("A", a.steps(24).toString())
        assertEquals("C", a.steps(27).toString())
        assertEquals("D#", a.steps(30).toString())
    }

    @Test
    fun stepsUpGTest() {
        val g = Note(10)
        assertEquals(g.toString(), "G")
        assertEquals("G#", g.steps(1).toString())
        assertEquals("A", g.steps(2).toString())
        assertEquals("A#", g.steps(3).toString())
        assertEquals("B", g.steps(4).toString())
        assertEquals("C", g.steps(5).toString())
    }

    @Test
    fun stepsDownATest() {
        val a = Note(0)
        assertEquals(a.toString(), "A")
        assertEquals("G#", a.steps(-1).toString())
        assertEquals("G", a.steps(-2).toString())
        assertEquals("F#", a.steps(-3).toString())
        assertEquals("F", a.steps(-4).toString())
    }

    @Test
    fun stepsDownASharpTest() {
        val aSharp = Note(1)
        assertEquals(aSharp.toString(), "A#")
        assertEquals("A", aSharp.steps(-1).toString())
        assertEquals("G#", aSharp.steps(-2).toString())
        assertEquals("G", aSharp.steps(-3).toString())
        assertEquals("F#", aSharp.steps(-4).toString())
    }

    @Test
    fun stepsDownBTest() {
        val b = Note(2)
        assertEquals(b.toString(), "B")
        assertEquals("A#", b.steps(-1).toString())
        assertEquals("A", b.steps(-2).toString())
        assertEquals("G#", b.steps(-3).toString())
        assertEquals("G", b.steps(-4).toString())
    }

    @Test
    fun stepsDownGTest() {
        val g = Note(10)
        assertEquals(g.toString(), "G")
        assertEquals("A", g.steps(-10).toString())
        assertEquals("G", g.steps(-12).toString())
        assertEquals("D", g.steps(-17).toString())
        assertEquals("G", g.steps(-24).toString())
    }
}