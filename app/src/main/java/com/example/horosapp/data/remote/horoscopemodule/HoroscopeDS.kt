package com.example.horosapp.data.remote.horoscopemodule

import com.example.horosapp.data.remote.horoscopemodule.response.HoroscopePredictionResponse
import pe.com.interbank.mobilebanking.domain.common.entities.DataResult

interface HoroscopeDS {

    suspend fun getHoroscopePrediction(sign: String): HoroscopePredictionResponse?

}