package de.manuelhuber.music.common.exercises

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import de.manuelhuber.music.R
import de.manuelhuber.music.common.exercises.FingerControlExerciseFragment
import de.manuelhuber.music.isNotEmptyString
import org.junit.Test

class FingerControlExerciseFragmentTest : FragmentTest() {
    override val fragment = FingerControlExerciseFragment.newInstance()

    /**
     * ^(;,,;)^
     */
    @Test
    fun sanityCheck() {
        button().isNotEmptyString()
        button().perform(click())
        button().isNotEmptyString()
    }

    private fun button() = onView(withId(R.id.buttonFingerControl))

}