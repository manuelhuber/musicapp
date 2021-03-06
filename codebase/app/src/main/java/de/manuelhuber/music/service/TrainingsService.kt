package de.manuelhuber.music.service

import android.arch.lifecycle.MutableLiveData
import de.manuelhuber.music.common.exercises.*
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class TrainingsService {
    private val exercises = mutableMapOf(
            Pair(NoteReadingFragment.newInstance(), true),
            Pair(FingerControlExerciseFragment.newInstance(), true),
            Pair(IntervalExerciseFragment.newInstance(), true),
            Pair(ScaleExerciseFragment.newInstance(), true),
            Pair(AccordExerciseFragment.newInstance(), true)
    )
    private val exercisesSubject = BehaviorSubject.create<List<ExerciseFragment>>()

    var timedExerciseDuration: MutableLiveData<Int> = MutableLiveData()

    init {
        publish()
        timedExerciseDuration.value = 30
    }

    fun toggleExercise(exerciseFragment: ExerciseFragment, active: Boolean) {
        exercises[exerciseFragment] = active
        publish()
    }

    fun allExercises(): Map<ExerciseFragment, Boolean> {
        return exercises
    }

    fun activeExercises(): Observable<List<ExerciseFragment>> {
        return exercisesSubject
    }

    private fun publish() {
        val exerciseList: List<ExerciseFragment> = exercises
                .filter { entry -> entry.value }
                .map { entry -> entry.key }
        exercisesSubject.onNext(exerciseList)
    }

}