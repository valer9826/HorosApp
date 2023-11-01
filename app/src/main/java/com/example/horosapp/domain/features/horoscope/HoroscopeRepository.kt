package com.example.horosapp.domain.features.horoscope

import com.example.horosapp.domain.features.horoscope.model.HoroscopePredictionModel

interface HoroscopeRepository {

    suspend fun getHoroscopePrediction(sign: String): HoroscopePredictionModel?

}