package com.example.champ.order

import com.example.domain.model.CoffeeModel

data class OrderOptionsState (
    val isSuccess: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String = "",
    val time: String = "18:10",
    val coffee: CoffeeModel? = null,
    val count: Int = 1,
    val ris: Int = 1,
    val pickup: Int = 1,
    val volume: Int = 1,
    val coast: Int = 100,
    val specTime: Boolean = true,

)