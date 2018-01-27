package de.manuel_huber.music.model

import org.junit.Test
import org.junit.Assert.*

class NoteTest {

    @Test
    fun stepsUpATest() {
        val a = Note(0)
        assertEquals(a.toString(), "A")
        assertEquals(a.steps(12).toString(), "A")
        assertEquals(a.steps(24).toString(), "A")
        assertEquals(a.steps(27).toString(), "C")
        assertEquals(a.steps(30).toString(), "D#")
    }

    @Test
    fun stepsUpGTest() {
        val g = Note(10)
        assertEquals(g.toString(), "G")
        assertEquals(g.steps(1).toString(), "G#")
        assertEquals(g.steps(2).toString(), "A")
        assertEquals(g.steps(3).toString(), "A#")
        assertEquals(g.steps(4).toString(), "B")
        assertEquals(g.steps(5).toString(), "C")
    }

    @Test
    fun stepsDownATest() {
        val a = Note(0)
        assertEquals(a.toString(), "A")
        assertEquals(a.steps(-1).toString(), "G#")
        assertEquals(a.steps(-2).toString(), "G")
        assertEquals(a.steps(-3).toString(), "F#")
        assertEquals(a.steps(-4).toString(), "F")
    }

    @Test
    fun stepsDownASharpTest() {
        val aSharp = Note(1)
        assertEquals(aSharp.toString(), "A#")
        assertEquals(aSharp.steps(-1).toString(), "A")
        assertEquals(aSharp.steps(-2).toString(), "G#")
        assertEquals(aSharp.steps(-3).toString(), "G")
        assertEquals(aSharp.steps(-4).toString(), "F#")
    }

    @Test
    fun stepsDownBTest() {
        val b = Note(2)
        assertEquals(b.toString(), "B")
        assertEquals(b.steps(-1).toString(), "A#")
        assertEquals(b.steps(-2).toString(), "A")
        assertEquals(b.steps(-3).toString(), "G#")
        assertEquals(b.steps(-4).toString(), "G")
    }

    @Test
    fun stepsDownGTest() {
        val g = Note(10)
        assertEquals(g.toString(), "G")
        assertEquals(g.steps(-10).toString(), "A")
        assertEquals(g.steps(-12).toString(), "G")
        assertEquals(g.steps(-17).toString(), "D")
        assertEquals(g.steps(-24).toString(), "G")
    }
}