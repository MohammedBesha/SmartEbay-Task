package com.smartepay.news.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable


abstract class BaseViewModel : ViewModel() {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    protected fun getCompositeDisposable(): CompositeDisposable {
        return compositeDisposable
    }
}