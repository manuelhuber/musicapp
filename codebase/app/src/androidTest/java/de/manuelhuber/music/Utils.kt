package de.manuelhuber.music

import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.not

fun ViewInteraction.isNotEmptyString(): ViewInteraction =
        this.check(matches(not(withText(""))))

fun ViewInteraction.isEmptyString(): ViewInteraction =
        this.check(matches(withText("")))

fun ViewInteraction.isVisible(): ViewInteraction =
        this.check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

fun ViewInteraction.isNotVisible(): ViewInteraction =
        this.check(matches(not(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))))

/**
 * Returns true if the condition is fulfilled
 */
fun ViewInteraction.toBool(condition: ViewInteraction.() -> Unit): Boolean {
    return try {
        this.condition()
        true
    } catch (e: AssertionError) {
        false
    }
}

/**
 * Ensures the condition is only true for only one of the two inputs
 */
fun exclusiveOr(a: ViewInteraction, b: ViewInteraction, condition: ViewInteraction.() -> Unit) {
    if (a.toBool(condition) == b.toBool(condition)) {
        throw AssertionError()
    }
}