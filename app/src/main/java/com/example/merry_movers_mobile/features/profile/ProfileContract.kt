package com.example.merry_movers_mobile.features.profile

interface ProfileContract {
    interface View {
        fun showProfileName(name: String)
        fun openMarket()
        fun playBackTransition()
    }

    interface Presenter {
        fun onViewReady()
        fun onHomeTabClicked()
        fun detach()
    }
}
