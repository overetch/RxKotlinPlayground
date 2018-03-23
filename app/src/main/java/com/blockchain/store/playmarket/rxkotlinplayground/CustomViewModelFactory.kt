package com.blockchain.store.playmarket.rxkotlinplayground

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by Crypton04 on 23.03.2018.
 */
class CustomViewModelFactory(private var view: BaseView) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val modelClass = super.create(modelClass)
        if (modelClass is BasePresenterImp) {
            modelClass.init(view)
        }
        //todo Probably needs to throw an Exception. Right here?  ¯\_(ツ)_/¯
        return modelClass
    }
}
