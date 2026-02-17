package com.example.champ.login

interface LoginEvents {
    data class OnEmailChange(val value: String): LoginEvents
    data class OnPasswordChange(val value: String): LoginEvents
    data object OnNextClick: LoginEvents
}