package de.manuelhuber.music.util

import io.reactivex.disposables.Disposable

fun Disposable.then(function: (Disposable) -> Unit) {
    function(this)
}