package com.example.champ.placed

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlacedViewModel @Inject constructor() : ViewModel() {
    private val _time = MutableStateFlow(false)
    val time = _time.onStart {
        delay(1500)
        _time.update { true }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)

}