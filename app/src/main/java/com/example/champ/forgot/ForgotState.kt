package com.example.champ.forgot

data class ForgotState (
    val isSuccess: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String = "",
    val email: String = ""
)