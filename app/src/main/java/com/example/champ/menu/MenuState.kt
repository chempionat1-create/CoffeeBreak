package com.example.champ.menu

import com.example.domain.model.CoffeeModel

data class MenuState (
    val isSuccess: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val isRating: Boolean = false,
    val error: String = "",
    val name: String = "",
    val coffees: List<CoffeeModel> = emptyList(),
    val rate: Int = 4
)