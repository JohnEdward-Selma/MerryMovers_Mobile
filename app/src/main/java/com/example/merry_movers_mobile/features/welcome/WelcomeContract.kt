package com.example.merry_movers_mobile.features.welcome

interface WelcomeContract {
    interface View {
        fun openLogin()
        fun openRegister()
        fun playForwardTransition()
    }

    interface Presenter {
        fun onCreateAccountClicked()
        fun onSignInClicked()
        fun detach()
    }
}
