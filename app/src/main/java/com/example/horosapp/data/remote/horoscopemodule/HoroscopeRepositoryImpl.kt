package com.example.horosapp.data.remote.horoscopemodule

import com.example.horosapp.domain.features.HoroscopeRepository
import com.example.horosapp.domain.features.horoscope.HoroscopePredictionModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class HoroscopeRepositoryImpl @Inject constructor(
    private val horoscopeDS: HoroscopeDS
) : HoroscopeRepository{
    override suspend fun getHoroscopePrediction(sign: String): HoroscopePredictionModel? {
        runCatching {
            horoscopeDS.getHoroscopePrediction(sign)
        }.onSuccess {
            return it?.toDomain()
        }.onFailure {

        }
        return null
    }

}