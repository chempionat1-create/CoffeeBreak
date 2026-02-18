package com.example.champ.profile

interface ProfileEvents {
    data class OnOpenDialog(val value: String): ProfileEvents
    data object OnExit: ProfileEvents

}