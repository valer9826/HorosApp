package com.example.horosapp.features.detail

import com.example.horosapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailUiState {

    data object Loading : HoroscopeDetailUiState()

    data class Error(val error: String) : HoroscopeDetailUiState()

    data class Success(val prediction: String, val sign: String, val horoscopeModel: HoroscopeModel) :
        HoroscopeDetailUiState()

}
