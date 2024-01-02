package com.example.horosapp.common.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "")
            .build()
        return chain.proceed(request)
    }
}

class TokenManager(){
    fun getToken() = "token"
}