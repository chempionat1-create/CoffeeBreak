package com.example.champ.items

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.champ.Route
import com.example.domain.usecase.items.GetBaristasUseCase
import com.example.domain.usecase.items.GetItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getBaristasUseCase: GetBaristasUseCase,
    private val getItemsUseCase: GetItemsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(ItemsState())
    val state: State<ItemsState> = _state

    init {
        val page = savedStateHandle.toRoute<Route.Constructor>().page!!
        when (page) {
            1 -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val res = getBaristasUseCase.execute()
                    if (res.isSuccess) {
                        withContext(Dispatchers.Main) {

                            _state.value = _state.value.copy(
                                baristas = res.getOrNull()!!,
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

            2 -> {

                viewModelScope.launch(Dispatchers.IO) {
                    val res = getItemsUseCase.execute("countries")
                    if (res.isSuccess) {
                        withContext(Dispatchers.Main) {

                            _state.value = _state.value.copy(
                                countries = res.getOrNull()!!,
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

            3 -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val res = getItemsUseCase.execute("sorts")
                    if (res.isSuccess) {
                        withContext(Dispatchers.Main) {

                            _state.value = _state.value.copy(
                                sorts = res.getOrNull()!!,
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

            else -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val res = getItemsUseCase.execute("additives")
                    if (res.isSuccess) {
                        withContext(Dispatchers.Main) {

                            _state.value = _state.value.copy(
                                additives = res.getOrNull()!!,
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
        }
        _state.value = _state.value.copy(
            page = page
        )
    }

    fun onEvent(event: ItemsEvents) {
        when (event) {

        }
    }
}