package com.example.horosapp.data.remote.horoscopemodule.response

import com.example.horosapp.domain.features.horoscope.model.HoroscopePredictionModel
import com.google.gson.annotations.SerializedName

data class HoroscopePredictionResponse(
    @SerializedName("date")
    val date: String,
    @SerializedName("horoscope")
    val horoscope: String,
    @SerializedName("sign")
    val sign: String
) {

    fun toDomain(): HoroscopePredictionModel {
        return HoroscopePredictionModel(
            horoscopePrediction = this.horoscope,
            sign = this.sign
        )
    }
}