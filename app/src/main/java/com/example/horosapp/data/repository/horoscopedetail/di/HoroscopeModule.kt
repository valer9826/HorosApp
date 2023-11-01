package com.example.horosapp.data.repository.horoscopedetail.di

import com.example.horosapp.data.repository.horoscopedetail.HoroscopeRepositoryImpl
import com.example.horosapp.domain.features.horoscope.HoroscopeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HoroscopeModule {

    @Binds
    @Singleton
    abstract fun bindHoroscopeRepository(horoscopeRepositoryImpl: HoroscopeRepositoryImpl): HoroscopeRepository
}