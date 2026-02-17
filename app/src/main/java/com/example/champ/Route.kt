package com.example.champ

import kotlinx.serialization.Serializable

@Serializable
sealed class Route() {
    @Serializable data object Welcome: Route()
    @Serializable data object Login: Route()
    @Serializable data object SignUp: Route()
}