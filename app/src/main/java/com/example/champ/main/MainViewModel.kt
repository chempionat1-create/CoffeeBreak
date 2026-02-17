package com.example.champ.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetSessionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSessionUseCase: GetSessionUseCase
): ViewModel() {
    private val _isAuth = MutableStateFlow(false)
    val isAuth = _isAuth.onStart {
        _isAuth.update { getSessionUseCase.execute() != null }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), false)
}