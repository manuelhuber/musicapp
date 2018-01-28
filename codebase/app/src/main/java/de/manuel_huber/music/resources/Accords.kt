package de.manuel_huber.music.resources

import android.content.Context
import android.content.res.Resources
import de.manuel_huber.music.model.Intervalls
import de.manuel_huber.music.model.Note
import de.manuel_huber.music.util.getRandomElement

val allAccords
    get () = listOf(
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

fun getRandomAccord(resources: Resources, context: Context): Intervalls {
    return getAccord(allAccords.getRandomElement(), resources, context)
}

fun getAccord(name: String, resources: Resources, context: Context): Intervalls {
    return Intervalls(
            getAccordString(name, resources, context)!!,
            getAccordSteps(name, resources, context)!!, Note())
}

fun getAccordSteps(name: String, resources: Resources, context: Context): IntArray? {
    return resources.getIntArray(resources.getIdentifier("array/$name", null, context.packageName))
}

fun getAccordString(name: String, resources: Resources, context: Context): String? {
    return resources.getString(resources.getIdentifier("string/accord_$name", null, context.packageName))
}