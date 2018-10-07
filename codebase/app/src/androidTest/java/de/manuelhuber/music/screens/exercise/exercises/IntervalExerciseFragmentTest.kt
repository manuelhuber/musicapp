package de.manuelhuber.music.screens.exercise.exercises

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import de.manuelhuber.music.R
import de.manuelhuber.music.exclusiveOr
import de.manuelhuber.music.isEmptyString
import de.manuelhuber.music.isVisible
import org.junit.Test

class IntervalExerciseFragmentTest : FragmentTest() {
    override val fragment = IntervalExerciseFragment.newInstance()

    /**
     * ^(;,,;)^
     */
    @Test
    fun sanityCheck() {
        for (i in 1..5) {
            exclusiveOr(imageStepsUp(), imageStepsDown()) { isVisible() }
            exclusiveOr(textStepsDown(), textStepsUp()) { isEmptyString() }
            button().perform(click())
        }
    }

    fun button() = onView(withId(R.id.layoutIntervalCenter))
    fun textStepsUp() = onView(withId(R.id.textStepsUp))
    fun imageStepsUp() = onView(withId(R.id.imageStepsUp))
    fun textStepsDown() = onView(withId(R.id.textStepsDown))
    fun imageStepsDown() = onView(withId(R.id.imageStepsDown))

}