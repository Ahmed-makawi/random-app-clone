package com.assignment.netclan.ui.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val screenState = mutableStateOf<UiState>(UiState.Explore)

    sealed class UiState {
        object Explore : UiState()
    }
}