package com.example.champ

import kotlinx.serialization.Serializable

@Serializable
sealed class Route() {
    @Serializable data object Welcome: Route()
    @Serializable data object Login: Route()
    @Serializable data object SignUp: Route()
    @Serializable data object StartUp: Route()
    @Serializable data object CafeMap: Route()
    @Serializable data object Forgot: Route()
    @Serializable data object Reset: Route()
    @Serializable data object Profile: Route()
    @Serializable data object MyOrder: Route()
    @Serializable data object Menu: Route()
    @Serializable data object Reward: Route()
    @Serializable data object QR: Route()
    @Serializable data object OrderOptions: Route()
    @Serializable data object TwoFactor: Route()
}