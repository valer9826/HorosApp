package com.example.horosapp.features.detail

sealed class HoroscopeDetailUiState {

    data object Loading : HoroscopeDetailUiState()

    data class Error(val error: String) : HoroscopeDetailUiState()

    data class Success(val data: String) : HoroscopeDetailUiState()

}
