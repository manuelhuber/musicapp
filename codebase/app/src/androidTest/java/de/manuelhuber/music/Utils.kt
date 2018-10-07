package de.manuelhuber.music

import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.not

fun ViewInteraction.isNotEmptyString(): ViewInteraction =
        this.check(ViewAssertions.matches(not(withText(""))))

fun ViewInteraction.isEmptyString(): ViewInteraction =
        this.check(ViewAssertions.matches(withText("")))
