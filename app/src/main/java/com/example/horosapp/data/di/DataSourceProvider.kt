package com.example.horosapp.data.di

import com.example.horosapp.data.remote.horoscopemodule.HoroscopeApi
import com.example.horosapp.data.remote.horoscopemodule.HoroscopeDS
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceProvider {

    @Binds
    abstract fun bindHoroscopeServiceDS(horoscopeApi: HoroscopeApi): HoroscopeDS

}