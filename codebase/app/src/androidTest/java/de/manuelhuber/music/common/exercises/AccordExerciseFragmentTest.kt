package de.manuelhuber.music.common.exercises

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import de.manuelhuber.music.R
import de.manuelhuber.music.common.exercises.AccordExerciseFragment
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
        for (i in 1..5) {
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

            button().perform(click())
        }
    }

    private fun textSteps() = onView(withId(R.id.textSteps))
    private fun textExercise() = onView(withId(R.id.textExercise))
    private fun textSolution() = onView(withId(R.id.textSolution))
    private fun button() = onView(withId(R.id.layoutExerciseButton))

}