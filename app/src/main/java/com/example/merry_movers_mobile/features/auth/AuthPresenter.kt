package com.example.merry_movers_mobile.features.auth

class AuthPresenter(
    private var view: AuthContract.View?,
    private val model: AuthModel
) : AuthContract.Presenter {

    override fun onBackClicked() {
        view?.openWelcome()
        view?.playBackTransition()
    }

    override fun onSwitchAuthClicked() {
        when (model.destination) {
            AuthDestination.LOGIN -> view?.openLogin()
            AuthDestination.REGISTER -> view?.openRegister()
        }
        view?.playForwardTransition()
    }

    override fun onPrimaryActionClicked() {
        when (model.primaryDestination) {
            AuthPrimaryDestination.MARKET -> view?.openMarket()
        }
        view?.playForwardTransition()
    }

    override fun onSystemBackPressed() {
        view?.playBackTransition()
    }

    override fun detach() {
        view = null
    }
}
