package com.example.champ.my_order

interface MyOrderEvents {
    data object OnPaymentChange: MyOrderEvents
    data object OnCloseDialog: MyOrderEvents
    data class OnPaymentMethodChange(val value: Int): MyOrderEvents
}