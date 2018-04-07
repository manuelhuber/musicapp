package de.manuel_huber.music.exercises

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import de.manuel_huber.music.R
import de.manuel_huber.music.SingleFragmentActivity
import de.manuel_huber.music.isEmptyString
import de.manuel_huber.music.isNotEmptyString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AccordsExerciseFragmentTest {

    private val testActivityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)

    @Rule
    fun rule() = testActivityRule

    @Before
    fun setUp() {
        rule().activity.setFragment(AccordsExerciseFragment.newInstance())
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