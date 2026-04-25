package com.example.merry_movers_mobile.features.auth

interface AuthContract {
    interface View {
        fun openWelcome()
        fun openLogin()
        fun openRegister()
        fun openMarket()
        fun playForwardTransition()
        fun playBackTransition()
    }

    interface Presenter {
        fun onBackClicked()
        fun onSwitchAuthClicked()
        fun onPrimaryActionClicked()
        fun onSystemBackPressed()
        fun detach()
    }
}
