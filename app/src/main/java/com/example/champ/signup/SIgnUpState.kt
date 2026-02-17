package com.example.champ.signup

data class SIgnUpState (
    val isSuccess: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String = "",
    val email: String = "",
    val password: String = "",
    val name: String = "",
    val phone: String = "",
)