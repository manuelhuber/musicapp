package de.manuelhuber.music.model.technical

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun disposeAtTheEnd(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
    }
}