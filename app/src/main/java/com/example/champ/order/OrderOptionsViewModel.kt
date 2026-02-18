package com.example.champ.order

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.champ.Route
import com.example.domain.usecase.coffee.GetCoffeeByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class OrderOptionsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCoffeeByIdUseCase: GetCoffeeByIdUseCase
) : ViewModel() {
    private val _state = mutableStateOf(OrderOptionsState())
    val state: State<OrderOptionsState> = _state

    init {
        val id = savedStateHandle.toRoute<Route.OrderOptions>().id
        viewModelScope.launch(Dispatchers.IO) {
            if (id.isNullOrBlank()) {
                withContext(Dispatchers.Main) {

                    _state.value = _state.value.copy(
                        isError = true,
                        error = "No id"
                    )
                }
            } else {
                val res = getCoffeeByIdUseCase.execute(id)
                if (res.isSuccess) {
                    withContext(Dispatchers.Main) {
                        _state.value = _state.value.copy(
                            isLoading = false,
                            coffee = res.getOrNull()!!
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
    }

    fun onEvent(event: OrderOptionsEvents) {
        when (event) {
            is OrderOptionsEvents.OnCountChange -> {
                when (event.action) {

                    "-" -> {
                        if (_state.value.count > 1) {

                            _state.value = _state.value.copy(
                                count = _state.value.count - 1
                            )
                        }
                    }

                    else -> {

                        _state.value = _state.value.copy(
                            count = _state.value.count + 1
                        )
                    }
                }
            }

            is OrderOptionsEvents.OnRisChange -> {
                _state.value = _state.value.copy(
                    ris = event.value
                )
            }

            is OrderOptionsEvents.OnPickupChange -> {
                _state.value = _state.value.copy(
                    pickup = event.value
                )
            }

            is OrderOptionsEvents.OnVolumeChange -> {
                _state.value = _state.value.copy(
                    volume = event.value
                )
            }
            OrderOptionsEvents.OnSpecTimeChange -> {
                _state.value = _state.value.copy(
                    specTime = !_state.value.specTime
                )
            }
        }
    }
}