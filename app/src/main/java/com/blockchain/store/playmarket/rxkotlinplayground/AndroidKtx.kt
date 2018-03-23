package com.blockchain.store.playmarket.rxkotlinplayground

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity

/**
 * Created by Crypton04 on 23.03.2018.
 */
class AndroidKtx {
    companion object {
        fun <T : ViewModel?> FragmentActivity.attachViewModel(viewModelClass: Class<T>): T {
            if (this is BaseView) {
                return ViewModelProviders.of(this, CustomViewModelFactory(this)).get(viewModelClass)
            }
            return ViewModelProviders.of(this).get(viewModelClass)
        }
    }


}