package com.example.merry_movers_mobile.features.profile

class ProfilePresenter(
    private var view: ProfileContract.View?,
    private val model: ProfileModel
) : ProfileContract.Presenter {

    override fun onViewReady() {
        view?.showProfileName(model.profileName)
    }

    override fun onHomeTabClicked() {
        view?.openMarket()
        view?.playBackTransition()
    }

    override fun detach() {
        view = null
    }
}
