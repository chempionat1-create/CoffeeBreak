package com.example.champ.menu

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.coffee.GetCoffeesUseCase
import com.example.domain.usecase.user.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getCoffeesUseCase: GetCoffeesUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    private val _state = mutableStateOf(MenuState())
    val state: State<MenuState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val res = getCoffeesUseCase.execute()
            val name = getUserUseCase.execute()
            if (res.isSuccess && name.isSuccess) {
                withContext(Dispatchers.Main) {
                    _state.value = _state.value.copy(
                        coffees = res.getOrNull()!!,
                        isLoading = false,
                        name = name.getOrNull()!!.name
                    )
                }
            } else {
                withContext(Dispatchers.Main) {
                    _state.value = _state.value.copy(
                        isError = true,
                        error = res.exceptionOrNull()?.message?: name.exceptionOrNull()!!.message!!
                    )
                }
            }
        }
    }

    fun onEvent(event: MenuEvents) {
        when (event) {
            MenuEvents.OnCloseDialog -> {
                _state.value = _state.value.copy(
                    isError = false
                )
            }

        }
    }
}