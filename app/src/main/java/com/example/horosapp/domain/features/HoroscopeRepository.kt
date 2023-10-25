package com.example.horosapp.domain.features

import com.example.horosapp.domain.features.horoscope.HoroscopePredictionModel

interface HoroscopeRepository {

    suspend fun getHoroscopePrediction(sign: String): HoroscopePredictionModel?

}