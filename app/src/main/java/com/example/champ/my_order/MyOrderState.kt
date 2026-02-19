package com.example.champ.my_order

import com.example.domain.model.UserModel

data class MyOrderState (
    val isSuccess: Boolean = false,
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val error: String = "",
    val isPayment: Boolean = false,
    val user: UserModel? = null,
    val method: Int = 1
)