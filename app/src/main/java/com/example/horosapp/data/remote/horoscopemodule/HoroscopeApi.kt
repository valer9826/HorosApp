package com.example.horosapp.data.remote.horoscopemodule

import com.example.horosapp.domain.model.HoroscopeModel
import com.horosapp.domain.horoscope.model.HoroscopeInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HoroscopeApi {

    @POST("/")
    suspend fun getHoroscopeInfo(): Response<HoroscopeInfo>

    @GET("/list")
    suspend fun getHoroscopeList(): Response<List<HoroscopeModel>>

    @GET("/{sign}")
    suspend fun getHoroscopeSignInfo(@Path("sign") sign: String): Response<HoroscopeModel>
}