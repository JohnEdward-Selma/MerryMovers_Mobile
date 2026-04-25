package com.example.merry_movers_mobile.features.welcome

class WelcomePresenter(
    private var view: WelcomeContract.View?,
    private val model: WelcomeModel
) : WelcomeContract.Presenter {

    override fun onCreateAccountClicked() {
        when (model.createAccountRoute) {
            WelcomeRoute.REGISTER -> view?.openRegister()
            WelcomeRoute.LOGIN -> view?.openLogin()
        }
        view?.playForwardTransition()
    }

    override fun onSignInClicked() {
        when (model.signInRoute) {
            WelcomeRoute.LOGIN -> view?.openLogin()
            WelcomeRoute.REGISTER -> view?.openRegister()
        }
        view?.playForwardTransition()
    }

    override fun detach() {
        view = null
    }
}
