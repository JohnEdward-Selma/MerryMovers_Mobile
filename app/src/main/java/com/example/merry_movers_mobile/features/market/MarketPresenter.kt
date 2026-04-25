package com.example.merry_movers_mobile.features.market

class MarketPresenter(
    private var view: MarketContract.View?,
    private val model: MarketModel
) : MarketContract.Presenter {

    override fun onViewReady() {
        view?.showHeader(model.title, model.subtitle)
    }

    override fun onProfileTabClicked() {
        view?.openProfile()
        view?.playForwardTransition()
    }

    override fun detach() {
        view = null
    }
}
