package de.manuel_huber.music.exercises

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import de.manuel_huber.music.R
import de.manuel_huber.music.SingleFragmentActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AccordsExerciseFragmentTest {


    val testActivityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)

    @Rule
    fun rule() = testActivityRule

    @Before
    fun setUp() {
        rule().activity.setFragment(AccordsExerciseFragment.newInstance())
    }

    @Test
    fun test() {
        onView(withId(R.id.textSteps)).check(ViewAssertions.matches(withText("")))
    }

}