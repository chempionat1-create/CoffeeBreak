package com.example.champ.cafemap

import com.example.domain.model.CafeModel
import com.yandex.mapkit.geometry.Point

data class CafeMapState (
    val isSuccess: Boolean = false,
    val isSettings: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String = "",
    val user: Point? = null,
    val cafes: List<CafeModel> = emptyList()
)