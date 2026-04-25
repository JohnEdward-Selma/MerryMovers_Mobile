package com.example.merry_movers_mobile.features.auth

data class AuthModel(
    val destination: AuthDestination,
    val primaryDestination: AuthPrimaryDestination = AuthPrimaryDestination.MARKET
)

enum class AuthDestination {
    LOGIN,
    REGISTER
}

enum class AuthPrimaryDestination {
    MARKET
}
