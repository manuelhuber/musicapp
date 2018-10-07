package de.manuelhuber.music.screens.exercise.exercises

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v4.app.Fragment
import de.manuelhuber.music.test.SingleFragmentActivity
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class FragmentTest {
    abstract val fragment: Fragment

    @Rule
    @JvmField
    val testActivityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)

    @Before
    fun setUp() {
        testActivityRule.activity.setFragment(fragment)
    }

}