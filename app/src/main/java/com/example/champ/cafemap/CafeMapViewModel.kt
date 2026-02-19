package com.example.champ.cafemap

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.coffee.GetCafesUseCase
import com.example.domain.usecase.coffee.SetAddressUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CafeMapViewModel @Inject constructor(
    private val getCafesUseCase: GetCafesUseCase,
    private val setAddressUseCase: SetAddressUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CafeMapState())
    val state: State<CafeMapState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val res = getCafesUseCase.execute()
            if (res.isSuccess) {
                withContext(Dispatchers.Main) {
                    _state.value = _state.value.copy(
                        cafes = res.getOrNull()!!,
                        isLoading = false
                    )
                }

            }
        }
    }

    fun onEvent(event: CafeMapEvents) {
        when (event) {
            CafeMapEvents.OnOpenDialog -> {
                _state.value = _state.value.copy(
                    isError = true, error = "Позвольте приложению использовать вашу геопозицию"
                )
            }
            CafeMapEvents.OnCloseDialog -> {
                _state.value = _state.value.copy(
                    isSettings = true,
                    isError = false
                )
            }
            is CafeMapEvents.OnAddressClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val res = setAddressUseCase.execute(event.value)
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