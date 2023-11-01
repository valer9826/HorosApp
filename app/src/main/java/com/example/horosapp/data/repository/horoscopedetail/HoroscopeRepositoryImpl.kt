package com.example.horosapp.data.repository.horoscopedetail

import com.example.horosapp.data.remote.horoscopemodule.HoroscopeDS
import com.example.horosapp.domain.features.horoscope.HoroscopeRepository
import com.example.horosapp.domain.features.horoscope.model.HoroscopePredictionModel
import javax.inject.Inject

class HoroscopeRepositoryImpl @Inject constructor(
    private val horoscopeDS: HoroscopeDS
) : HoroscopeRepository {
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