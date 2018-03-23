package com.blockchain.store.playmarket.rxkotlinplayground.LoginScreen

import com.blockchain.store.playmarket.rxkotlinplayground.BasePresenter
import com.blockchain.store.playmarket.rxkotlinplayground.BaseView

/**
 * Created by Crypton04 on 23.03.2018.
 */
class LoginContract {
    interface LoginView : BaseView {
        fun doSmth()
    }

    interface LoginPresenter : BasePresenter {
        fun login(login: String, pwd: String)
    }
}