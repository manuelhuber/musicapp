package de.manuelhuber.music.exercises

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import de.manuelhuber.music.R
import de.manuelhuber.music.SingleFragmentActivity
import de.manuelhuber.music.isEmptyString
import de.manuelhuber.music.isNotEmptyString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AccordExerciseFragmentTest {

    @Rule
    @JvmField
    val testActivityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)

    @Before
    fun setUp() {
        testActivityRule.activity.setFragment(AccordExerciseFragment.newInstance())
    }

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