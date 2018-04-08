package de.manuelhuber.music.resources

import android.content.Context
import android.content.res.Resources
import de.manuelhuber.music.model.IntervalSeries
import de.manuelhuber.music.model.Note
import de.manuelhuber.music.util.getRandomElement

val allScales
    get () = listOf(
            "major",
            "minor",
            "harmonic_minor",
            "hungarian_minor",
            "hungarian_major",
            "blues",
            "pentatonic_major",
            "pentatonic_minor",
            "spanish_eight",
            "oriental",
            "reduced",
            "overtone",
            "enigmatic"
    )

fun getRandomScale(resources: Resources, context: Context): IntervalSeries {
    return getScale(allScales.getRandomElement(), resources, context)
}

fun getScale(name: String, resources: Resources, context: Context): IntervalSeries {
    return IntervalSeries(
            getScaleString(name, resources, context)!!,
            getScaleSteps(name, resources, context)!!, Note())
}

fun getScaleSteps(name: String, resources: Resources, context: Context): IntArray? {
    return resources.getIntArray(resources.getIdentifier("array/$name", null, context.packageName))
}

fun getScaleString(name: String, resources: Resources, context: Context): String? {
    return resources.getString(resources.getIdentifier("string/scale_$name", null, context.packageName))
}