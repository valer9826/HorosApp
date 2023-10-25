package com.example.horosapp.data.di

import com.example.horosapp.data.remote.horoscopemodule.HoroscopeDS
import com.example.horosapp.data.remote.horoscopemodule.HoroscopeDSImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceProvider {

    @Binds
    @Singleton
    abstract fun bindHoroscopeServiceDS(horoscopeDS: HoroscopeDSImpl): HoroscopeDS

}