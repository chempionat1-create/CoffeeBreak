package com.example.champ.reset

interface ResetEvents {
    data class OnPasswordChange(val value: String): ResetEvents
}