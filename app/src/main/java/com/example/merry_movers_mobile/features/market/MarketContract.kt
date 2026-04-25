package com.example.merry_movers_mobile.features.market

interface MarketContract {
    interface View {
        fun showHeader(title: String, subtitle: String)
        fun openProfile()
        fun playForwardTransition()
    }

    interface Presenter {
        fun onViewReady()
        fun onProfileTabClicked()
        fun detach()
    }
}
