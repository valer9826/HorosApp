package com.example.horosapp.features.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horosapp.domain.features.horoscope.HoroscopeRepository
import com.example.horosapp.domain.features.horoscope.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(
    private val getPredictionUseCase: GetPredictionUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow<HoroscopeDetailUiState>(HoroscopeDetailUiState.Loading)
    val uiState: StateFlow<HoroscopeDetailUiState> = _uiState

    fun getHoroscope(sign: String) {
        viewModelScope.launch {
            _uiState.value = HoroscopeDetailUiState.Loading
            val result = withContext(Dispatchers.IO){
                getPredictionUseCase(sign)
            }
            if(result != null){
                _uiState.value = HoroscopeDetailUiState.Success(result.horoscopePrediction, result.sign)
            } else {
                _uiState.value = HoroscopeDetailUiState.Error("Has ocurrido un error, inténtelo más tarde")
            }
        }
    }

}