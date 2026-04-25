package com.example.merry_movers_mobile.features.welcome

data class WelcomeModel(
    val createAccountRoute: WelcomeRoute = WelcomeRoute.REGISTER,
    val signInRoute: WelcomeRoute = WelcomeRoute.LOGIN
)

enum class WelcomeRoute {
    LOGIN,
    REGISTER
}
