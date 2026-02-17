package com.example.champ.two_factor

data class TwoFactorState (
    val isSuccess: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String = "",
    val otp: String = ""
)