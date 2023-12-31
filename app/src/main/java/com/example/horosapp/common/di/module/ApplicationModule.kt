package com.example.horosapp.common.di.module

import android.content.Context
import com.example.horosapp.BuildConfig
import com.example.horosapp.HorosApp
import com.example.horosapp.common.interceptors.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

const val TIMEOUT: Long = 4L
const val BASE_URL = "https://newastro.vercel.app/"
@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideApplicationContext(
        @ApplicationContext context: Context
    ): HorosApp {
        return context as HorosApp
    }

    @Provides
    @Named("loggingInterceptor")
    fun provideLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.apply {
                level = HttpLoggingInterceptor.Level.HEADERS
                level = HttpLoggingInterceptor.Level.BODY
            }
        } else {
            interceptor.apply {
                level = HttpLoggingInterceptor.Level.NONE
            }
        }
        return interceptor
    }

    @Provides
    @Named("headerInterceptor")
    fun provideHeaderInterceptor(): Interceptor =
        Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("", "")
                .build()

            chain.proceed(request)
        }
//        object: Interceptor {
//            override fun intercept(chain: Interceptor.Chain): Response {
//                val request = chain.request().newBuilder()
//                    .addHeader("", "")
//                    .build()
//
//                return chain.proceed(request)
//            }
//        }

    @Provides
    fun provideGsonConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideGlobalEventClient(
        @Named("loggingInterceptor") loggingInterceptor: Interceptor,
        authInterceptor: AuthInterceptor
    ): OkHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .addInterceptor(authInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideGlobalEventRetrofit(
        gsonConverterFactory: Converter.Factory,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
}