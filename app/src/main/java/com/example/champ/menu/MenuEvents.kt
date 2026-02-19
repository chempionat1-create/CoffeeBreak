package com.example.champ.menu

interface MenuEvents {
    data object OnCloseDialog: MenuEvents
    data object OnDismFeedback: MenuEvents
    data class OnRateChange(val value: Int): MenuEvents
    data class OnSetRate(val value: Int): MenuEvents
}