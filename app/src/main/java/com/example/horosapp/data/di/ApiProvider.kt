package com.example.horosapp.data.di

import com.example.horosapp.data.remote.horoscopemodule.HoroscopeServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class ApiProvider {

    @Provides
    fun provideHoroscopeApi(retrofit: Retrofit): HoroscopeServiceApi {
        return retrofit.create(HoroscopeServiceApi::class.java)
    }

}