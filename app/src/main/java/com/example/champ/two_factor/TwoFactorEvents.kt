package com.example.champ.two_factor

interface TwoFactorEvents {
    data class OnDigitEntered(val value: String): TwoFactorEvents
    data object OnEnterEnded: TwoFactorEvents
}