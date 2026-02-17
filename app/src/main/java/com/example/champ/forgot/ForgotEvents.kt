package com.example.champ.forgot

interface ForgotEvents {
    data class OnEmailChange(val value: String): ForgotEvents
}