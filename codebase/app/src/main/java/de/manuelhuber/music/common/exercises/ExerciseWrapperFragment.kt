package de.manuelhuber.music.common.exercises

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.manuelhuber.music.R
import kotlinx.android.synthetic.main.fragment_exercise_wrapper.*


class ExerciseWrapperFragment : Fragment() {
    private var frag: ExerciseFragment? = null
    private var bitmap: Bitmap? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_exercise_wrapper, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (frag == null) return
        fragmentTitle.text = getString(frag!!.title)
        fragmentDescription.text = getString(frag!!.description)
        childFragmentManager
                .beginTransaction()
                .add(exerciseFragment.id, frag!!)
                .commit()
    }

    fun setExercise(exerciseFragment: ExerciseFragment) {
        frag = exerciseFragment
    }


    // ------------------------------- FUCKING FILTHY HACK WARNING --------------------------------
    /**
     * This is a workaround for the "disappearing child fragment" issue where the child fragment
     * ( = the actual exercise fragment) would disappear when the out animation starts.
     * We basically take a picture and set it as background for the out-animation
     * This solution taken from here:
     * https://stackoverflow.com/a/15017771
     */
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onPause() {
        if (isRemoving) bitmap = loadBitmapFromView(view!!)
        super.onPause()
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    fun loadBitmapFromView(v: View): Bitmap {
        val bitmap = Bitmap.createBitmap(v.width,
                v.height, Bitmap.Config.ARGB_8888)
        val c = Canvas(bitmap)
        if (v.width > 0 && v.height > 0) {
            v.layout(0, 0, v.width,
                    v.height)
            v.draw(c)
        }
        return bitmap
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onDestroyView() {
        val drawable = BitmapDrawable(resources, bitmap)
        exerciseFragmentWrapper.background = drawable
        bitmap = null
        super.onDestroyView()
    }
    // ------------------------------- FUCKING FILTHY HACK OVER ------------------------------------

}
