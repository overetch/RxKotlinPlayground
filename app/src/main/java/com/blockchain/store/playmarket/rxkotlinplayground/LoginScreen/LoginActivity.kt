package com.blockchain.store.playmarket.rxkotlinplayground.LoginScreen

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import com.blockchain.store.playmarket.rxkotlinplayground.*
import com.blockchain.store.playmarket.rxkotlinplayground.AndroidKtx.Companion.attachViewModel
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.login_screen.*

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {
    override fun doSmth() {

    }

    private val compositeDisposable = CompositeDisposable()

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

//        ViewModelProviders.of(this, CustomViewModelFactory(this)).get(LoginPresenter::class.java)
        presenter = attachViewModel(LoginPresenter::class.java)
    }

    private fun setViews() {
        val subscription: Observable<Boolean> = Observable.combineLatest(
                RxTextView.textChanges(userNameField).map { text -> text.trim() },
                RxTextView.textChanges(userNamePwd).map { text -> text.trim() },
                BiFunction { userName, pwd -> userName.isNotEmpty() && pwd.isNotEmpty() }
        )
        compositeDisposable.add(subscription.subscribe { bool -> nextButton.isEnabled = bool })
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

//    fun <T : ViewModel?> FragmentActivity.attachViewModel(viewModelClass: Class<T>): T {
//        if (this is BaseView) {
//            return ViewModelProviders.of(this, CustomViewModelFactory(this)).get(viewModelClass)
//        }
//        return ViewModelProviders.of(this).get(viewModelClass)
//    }

}



