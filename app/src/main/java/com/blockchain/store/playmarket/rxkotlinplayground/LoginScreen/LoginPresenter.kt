package com.blockchain.store.playmarket.rxkotlinplayground.LoginScreen

import android.util.Log
import com.blockchain.store.playmarket.rxkotlinplayground.BasePresenterImp
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Crypton04 on 23.03.2018.
 */
class LoginPresenter : BasePresenterImp(), LoginContract.LoginPresenter {
    init {
        doCrazy()
    }

    private fun doCrazy() {
        compositeDisposable.add(
                Observable.range(0, 10)
                        .map { Thread.sleep(3000) }
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            Log.d("LoginPresenter", "Doing smth")
                        }))

    }

    override fun login(login: String, pwd: String) {
        TODO("not implemented") //To change body attachViewModel created functions use File | Settings | File Templates.
    }

}