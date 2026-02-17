package com.example.champ.two_factor

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TwoFactorViewModel @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(TwoFactorState())
    val state: State<TwoFactorState> = _state
//
    fun onEvent(event: TwoFactorEvents) {
        when (event) {
            TwoFactorEvents.OnEnterEnded -> {
                _state.value = _state.value.copy(
                    isSuccess = true
                )
            }
            is TwoFactorEvents.OnDigitEntered -> {
                _state.value = _state.value.copy(
                    otp = event.value
                )
            }
        }
    }
}