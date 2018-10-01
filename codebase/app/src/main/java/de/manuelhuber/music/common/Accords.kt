package de.manuelhuber.music.common

import android.content.Context
import android.content.res.Resources
import de.manuelhuber.music.model.IntervalSeries
import de.manuelhuber.music.model.Note
import de.manuelhuber.music.util.getRandomElement

val accordKeys = listOf(
        "major_accord",
        "minor_accord",
        "dominant_seventh",
        "minor_seventh",
        "major_seventh",
        "major_added_second",
        "minor_added_second",
        "major_sixth",
        "suspended",
        "dominant_seventh_suspended_fourth",
        "suspended_second",
        "diminished",
        "diminished_seventh",
        "augmented",
        "minor_sixth",
        "minor_seventh_flat_five",
        "minor_major_seventh",
        "dominant_seventh_flat_five",
        "dominant_seventh_sharp_five",
        "major_seventh_flat_five",
        "major_seventh_sharp_five",
        "six_nine",
        "major_added_ninth",
        "ninth",
        "major_ninth",
        "minor_ninth",
        "seventh_flat_nine",
        "seventh_sharp_nine",
        "seventh_flat_five_flat_nine",
        "seventh_sharp_five_flat_nine",
        "seventh_flat_five_sharp_nine",
        "seventh_sharp_five_sharp_nine",
        "eleventh",
        "seventh_sharp_eleventh",
        "minor_eleventh",
        "thirteenth",
        "minor_thirteenth"
)

/**
 * Returns a random accord
 */
fun getRandomAccord(resources: Resources, context: Context): IntervalSeries {
    return getAccord(accordKeys.getRandomElement(), resources, context)
}

/**
 * Returns a IntervalSeries object for the given accord key
 */
private fun getAccord(accordKey: String, resources: Resources, context: Context): IntervalSeries {
    return IntervalSeries(
            getAccordStringKey(accordKey, resources, context)!!,
            getAccordSteps(accordKey, resources, context)!!,
            Note())
}

/**
 * Returns the interval steps for the accord key
 */
private fun getAccordSteps(accordKey: String, resources: Resources, context: Context): IntArray? {
    return resources.getIntArray(resources.getIdentifier("array/$accordKey", null, context.packageName))
}

/**
 * Returns the key for the string resource of the accord name
 */
private fun getAccordStringKey(accordKey: String, resources: Resources, context: Context): String? {
    return resources.getString(resources.getIdentifier("string/accord_$accordKey", null, context.packageName))
}