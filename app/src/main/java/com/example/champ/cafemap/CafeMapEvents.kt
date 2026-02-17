package com.example.champ.cafemap

import com.yandex.mapkit.geometry.Point

interface CafeMapEvents {
    data object OnOpenDialog: CafeMapEvents
    data object OnCloseDialog: CafeMapEvents
    data class UpdateUser(val value: Point): CafeMapEvents
    data class OnAddressClick(val value: String): CafeMapEvents
}