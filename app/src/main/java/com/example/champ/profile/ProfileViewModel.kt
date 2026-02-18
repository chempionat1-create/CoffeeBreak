package com.example.champ.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.champ.R
import com.example.domain.usecase.user.GetUserUseCase
import com.example.domain.usecase.utils.ExitSessionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val exitSessionUseCase: ExitSessionUseCase
) : ViewModel() {
    private val _state = mutableStateOf(ProfileState())
    val state: State<ProfileState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val res = getUserUseCase.execute()
            if (res.isSuccess) {
                val user = res.getOrNull()!!
                _state.value = _state.value.copy(
                    isLoading = false,
                    items = listOf(
                        Item(R.drawable.profile, "Имя", user.name, R.drawable.edit),
                        Item(R.drawable.phone_icon, "Номер телефона", user.phone, R.drawable.edit),
                        Item(R.drawable.email_icon, "Почта", user.email, R.drawable.edit),
                        Item(
                            R.drawable.location,
                            "Адрес кофейни Magic Coffee",
                            user.address ?: "",
                            R.drawable.edit
                        ),
                        Item(
                            R.drawable.qr,
                            "QR-код",
                            "Для получения заказа",
                            R.drawable.next2
                        ),

                        )
                )
            } else {
                _state.value = _state.value.copy(
                    isError = true,
                    error = res.exceptionOrNull()!!.message!!
                )
            }
        }
    }

    fun onEvent(event: ProfileEvents) {
        when (event) {

            ProfileEvents.OnExit -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val res = exitSessionUseCase.execute()
                }
            }
        }
    }
}