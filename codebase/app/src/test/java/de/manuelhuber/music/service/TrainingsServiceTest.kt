package de.manuelhuber.music.service

import de.manuelhuber.music.model.ExerciseFragment
import org.junit.Before
import org.junit.Test

class TrainingsServiceTest {

    lateinit var service: TrainingsService

    @Before
    fun setup() {
        service = TrainingsService()
    }

    @Test
    fun defaultValues() {
        assert(service.allExercises().size == 5)
        assert(service.allExercises().all { entry -> entry.value })
    }

    @Test
    fun toggleExercise() {
        val exercises = service.allExercises().keys.toList()
        val sub = service.activeExercises().test()

        for (ex in exercises) {
            service.toggleExercise(ex, false)
        }

        for (ex in exercises) {
            service.toggleExercise(ex, true)
        }

        sub.assertValueCount(11)
                .assertValueAt(0) { t -> t.size == 5 }
                .assertValueAt(1) { t -> t.size == 4 }
                .assertValueAt(2) { t -> t.size == 3 }
                .assertValueAt(3) { t -> t.size == 2 }
                .assertValueAt(4) { t -> t.size == 1 }
                .assertValueAt(5, List<ExerciseFragment>::isEmpty)
                .assertValueAt(6) { t -> t.size == 1 }
                .assertValueAt(7) { t -> t.size == 2 }
                .assertValueAt(8) { t -> t.size == 3 }
                .assertValueAt(9) { t -> t.size == 4 }
                .assertValueAt(10) { t -> t.size == 5 }
    }
}