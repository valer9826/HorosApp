package com.example.horosapp.domain.features.horoscope.usecase

import com.example.horosapp.domain.features.horoscope.HoroscopeRepository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(
    private val repository: HoroscopeRepository
) {


}