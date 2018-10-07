package de.manuelhuber.music.screens.exercise.exercises

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import de.manuelhuber.music.R
import de.manuelhuber.music.isEmptyString
import de.manuelhuber.music.isNotEmptyString
import org.junit.Test


class AccordExerciseFragmentTest : FragmentTest() {

    override val fragment = AccordExerciseFragment.newInstance()

    /**
     * ^(;,,;)^
     */
    @Test
    fun sanityCheck() {
        textExercise().isNotEmptyString()
        textSteps().isEmptyString()
        textSolution().isEmptyString()

        button().perform(click())

        textExercise().isNotEmptyString()
        textSteps().isNotEmptyString()
        textSolution().isEmptyString()

        button().perform(click())

        textExercise().isNotEmptyString()
        textSteps().isNotEmptyString()
        textSolution().isNotEmptyString()
    }

    private fun textSteps() = onView(withId(R.id.textSteps))
    private fun textExercise() = onView(withId(R.id.textExercise))
    private fun textSolution() = onView(withId(R.id.textSolution))
    private fun button() = onView(withId(R.id.layoutExerciseButton))

}