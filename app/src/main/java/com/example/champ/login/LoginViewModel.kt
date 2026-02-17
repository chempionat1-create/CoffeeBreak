package com.example.champ.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.auth.ValidateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateUseCase: ValidateUseCase
): ViewModel() {
    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun onEvent(event: LoginEvents) {
        when (event) {
            is LoginEvents.OnEmailChange -> {
                _state.value = _state.value.copy(
                    email = event.value
                )
            }
            is LoginEvents.OnPasswordChange -> {
                _state.value = _state.value.copy(
                    password = event.value
                )
            }
            LoginEvents.OnNextClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val res = validateUseCase.execute(_state.value.email, _state.value.password)
                    if (res.isSuccess) {
                        _state.value = _state.value.copy(
                            isSuccess = true
                        )
                    } else {
                        _state.value = _state.value.copy(
                            isError = true,
                            error = res.exceptionOrNull()!!.message!!
                        )
                    }
                }

            }
        }
    }
}