package com.example.champ.order

interface OrderOptionsEvents {

    data class OnCountChange(val action: String): OrderOptionsEvents
    data class OnRisChange(val value: Int): OrderOptionsEvents
    data class OnPickupChange(val value: Int): OrderOptionsEvents
    data class OnVolumeChange(val value: Int): OrderOptionsEvents
    data object OnSpecTimeChange: OrderOptionsEvents
}