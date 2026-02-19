package com.example.champ.my_order

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.user.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MyOrderViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private val _state = mutableStateOf(MyOrderState())
    val state: State<MyOrderState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val res = getUserUseCase.execute()
            if (res.isSuccess) {
                withContext(Dispatchers.Main) {
                    _state.value = _state.value.copy(
                        user = res.getOrNull()!!,
                        isLoading = false
                    )
                }
            } else {
                withContext(Dispatchers.Main) {
                    _state.value = _state.value.copy(
                        isError = true,
                        error = res.exceptionOrNull()!!.message!!
                    )
                }
            }
        }
    }

    fun onEvent(event: MyOrderEvents) {
        when (event) {
            MyOrderEvents.OnPaymentChange -> {
                _state.value = _state.value.copy(
                    isPayment = !_state.value.isPayment
                )
            }
            MyOrderEvents.OnCloseDialog -> {
                _state.value = _state.value.copy(
                    isError = false
                )
            }
            is MyOrderEvents.OnPaymentMethodChange -> {
                _state.value = _state.value.copy(
                    method = event.value
                )
            }
        }
    }
}