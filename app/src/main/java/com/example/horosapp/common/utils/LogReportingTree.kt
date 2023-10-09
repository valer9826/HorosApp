package com.example.horosapp.common.utils

import android.util.Log
import timber.log.Timber

class LogReportingTree: Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        when (priority) {
            Log.VERBOSE,
            Log.DEBUG -> {
                return
            }
        }
    }
}