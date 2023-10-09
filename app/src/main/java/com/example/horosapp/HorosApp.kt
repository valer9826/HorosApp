package com.example.horosapp

import android.app.Application
import com.example.horosapp.common.utils.LogReportingTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class HorosApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(LogReportingTree())
        }
    }

}