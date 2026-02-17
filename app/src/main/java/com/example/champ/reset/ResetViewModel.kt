package com.example.champ.reset

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResetViewModel @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(ResetState())
    val state: State<ResetState> = _state

    fun onEvent(event: ResetEvents) {
        when (event) {

        }
    }
}