package com.example.horosapp.data.remote.horoscopemodule

import android.util.Log
import com.example.horosapp.data.remote.horoscopemodule.response.HoroscopePredictionResponse
import javax.inject.Inject

class HoroscopeDSImpl @Inject constructor(
    private val api: HoroscopeServiceApi
) : HoroscopeDS {
    override suspend fun getHoroscopePrediction(sign: String): HoroscopePredictionResponse? {
        runCatching {
            api.getHoroscopePrediction(sign)
        }.onSuccess {
            return it
        }.onFailure {
            Log.i("Renato", "ha ocurrido un error ${it.message}")
        }
        return null
//        return safeApiCall {
//            api.getHoroscopePrediction(sign)
//        }
    }
}