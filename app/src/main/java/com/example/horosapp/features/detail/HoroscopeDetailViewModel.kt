package com.example.horosapp.features.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.horosapp.domain.features.horoscope.HoroscopeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(
    private val repository: HoroscopeRepository
): ViewModel() {

    private var _uiState = MutableStateFlow<HoroscopeDetailUiState>(HoroscopeDetailUiState.Loading)
    val uiState: StateFlow<HoroscopeDetailUiState> = _uiState


    init {
        viewModelScope.launch {
//            repository.getHoroscopePrediction()
        }
    }


}