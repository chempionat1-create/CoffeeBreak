package com.example.champ.signup

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.UserModel
import com.example.domain.usecase.auth.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.sign

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
): ViewModel() {
    private val _state = mutableStateOf(SIgnUpState())
    val state: State<SIgnUpState> = _state

    fun onEvent(event: SignUpEvents) {
        when (event) {
            is SignUpEvents.OnEmailChange -> {
                _state.value = _state.value.copy(
                    email = event.value
                )
            }
            is SignUpEvents.OnNameChange -> {
                _state.value = _state.value.copy(
                    name = event.value
                )
            }
            is SignUpEvents.OnPhoneChange -> {
                _state.value = _state.value.copy(
                    phone = event.value
                )
            }
            is SignUpEvents.OnPasswordChange -> {
                _state.value = _state.value.copy(
                    password = event.value
                )
            }
            SignUpEvents.OnNextClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val res = signUpUseCase.execute(_state.value.email, _state.value.password,
                        UserModel(
                            name = _state.value.name,
                            phone = _state.value.phone,
                        )
                    )
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