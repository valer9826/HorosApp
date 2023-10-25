package com.example.horosapp.data.utils

import com.example.horosapp.BuildConfig
import com.example.horosapp.data.common.entities.HttpErrorResponse
import com.example.horosapp.domain.common.entities.DataError
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import pe.com.interbank.mobilebanking.domain.common.entities.DataResult
import retrofit2.HttpException
import retrofit2.Response
import java.net.UnknownHostException
import javax.net.ssl.SSLException

const val ERROR_MESSAGE_DEFAULT = "ERROR GÉNERICO"
suspend fun <T : Any> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> Response<T>
): DataResult<T> {
    return withContext(dispatcher) {
        try {
            val result = apiCall()
            determinateSuccessResponse(result)
        } catch (ex: Exception) {
            determinateExceptionResponse(ex)
        }
    }
}

suspend fun <T : Any> determinateSuccessResponse(
    result: Response<T>
): DataResult<T> {
    val body = result.body()!!
    return if (result.isSuccessful) {
        DataResult.Success(
            data = body
        )
    } else {
        val httpError =
            Gson().fromJson(result.errorBody()?.stringSuspending(), HttpErrorResponse::class.java)
        DataError.HttpError(
            code = result.code().toString(),
            message = httpError.message,
            body = result.errorBody()?.stringSuspending(),
            isGlobalEvent = false
        )
    }
}

suspend fun <T : Any> determinateExceptionResponse(
    ex: Exception
): DataResult<T> {
    return when (ex) {
        is TimeoutCancellationException -> DataError.Timeout(
            message = ex.message,
            cause = ex.cause,
            isGlobalEvent = false
        )

        is UnknownHostException -> DataError.UnknownHost(
            cause = ex.cause,
            message = if (BuildConfig.DEBUG) ex.message else ERROR_MESSAGE_DEFAULT,
            isGlobalEvent = false
        )

        is HttpException -> DataError.HttpError(
            code = ex.code().toString(),
            cause = ex.cause,
            message = ex.message,
            body = ex.response()?.errorBody()?.stringSuspending(),
            isGlobalEvent = false
        )

        is SSLException -> DataError.SSLError(
            cause = ex,
            message = ex.message,
            isGlobalEvent = false
        )

        else -> {
            DataError.Unknown(
                cause = ex.cause,
                message = if (BuildConfig.DEBUG) ex.message else ERROR_MESSAGE_DEFAULT,
                isGlobalEvent = false
            )
        }
    }
}

@Suppress("BlockingMethodInNonBlockingContext")
suspend fun ResponseBody.stringSuspending() = try {
    withContext(Dispatchers.IO) { string() }
} catch (_: Exception) {
    null
}