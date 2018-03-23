package com.blockchain.store.playmarket.rxkotlinplayground

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Crypton04 on 23.03.2018.
 */

abstract class BasePresenterImp : BasePresenter, LifecycleObserver, ViewModel() {
    protected val compositeDisposable = CompositeDisposable()
    var baseView: BaseView? = null

    override fun init(view: BaseView) {
        this.baseView = view
        this.baseView?.lifecycle?.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun disposeAll() {
        compositeDisposable.clear()
    }

}
