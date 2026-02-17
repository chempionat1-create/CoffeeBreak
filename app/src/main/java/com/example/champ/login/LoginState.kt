package com.example.champ.login

data class LoginState (
    val isSuccess: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String = "",
    val email: String = "",
    val password: String = "",
)