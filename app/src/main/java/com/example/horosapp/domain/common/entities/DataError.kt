package com.example.horosapp.domain.common.entities

import pe.com.interbank.mobilebanking.domain.common.entities.DataResult

sealed class DataError(
    code: String? = null,
    message: String? = null,
    cause: Throwable? = null,
    isGlobalEvent: Boolean
): DataResult.Error(code, message, cause, isGlobalEvent) {

    class HttpError(
        code: String,
        message: String? = null,
        cause: Throwable? = null,
        val body: String? = null,
        isGlobalEvent: Boolean
    ): DataError(
        code = code,
        message = message,
        cause = cause,
        isGlobalEvent = isGlobalEvent
    )

    class UnknownHost(
        message: String? = null,
        cause: Throwable? = null,
        isGlobalEvent: Boolean
    ): DataError(
        message = message,
        cause = cause,
        isGlobalEvent = isGlobalEvent
    )

    class Unknown(
        message: String? = null,
        cause: Throwable? = null,
        isGlobalEvent: Boolean
    ): DataError(
        message = message,
        cause = cause,
        isGlobalEvent = isGlobalEvent
    )

    class Timeout(
        message: String? = null,
        cause: Throwable? = null,
        isGlobalEvent: Boolean
    ): DataError(
        message = message,
        cause = cause,
        isGlobalEvent = isGlobalEvent
    )

    class MissingResponse(
        code: String = GENERAL_ERROR,
        message: String = "",
        isGlobalEvent: Boolean
    ): DataError(
        code = code,
        message = message,
        cause = null,
        isGlobalEvent = isGlobalEvent
    )

    class SessionExpired(
        code: String,
        message: String,
        throwable: Throwable,
        isGlobalEvent: Boolean
    ): DataError(
        code = code,
        message = message,
        cause = throwable,
        isGlobalEvent = isGlobalEvent
    )

    class BadRequest(
        code: String,
        message: String,
        throwable: Throwable,
        isGlobalEvent: Boolean
    ): DataError(
        code = code,
        message = message,
        cause = throwable,
        isGlobalEvent = isGlobalEvent
    )

    class Unauthorized(
        code: String,
        message: String,
        throwable: Throwable,
        isGlobalEvent: Boolean
    ): DataError(
        code = code,
        message = message,
        cause = throwable,
        isGlobalEvent = isGlobalEvent
    )

    class NotFound(
        code: String,
        message: String,
        throwable: Throwable,
        isGlobalEvent: Boolean
    ): DataError(
        code = code,
        message = message,
        cause = throwable,
        isGlobalEvent = isGlobalEvent
    )

    class InternalServerError(
        code: String,
        message: String,
        throwable: Throwable,
        isGlobalEvent: Boolean
    ): DataError(
        code = code,
        message = message,
        cause = throwable,
        isGlobalEvent = isGlobalEvent
    )
    class BackOfficeTest(
        code: String,
        message: String,
        throwable: Throwable,
        isGlobalEvent: Boolean
    ): DataError(
        code = code,
        message = message,
        cause = throwable,
        isGlobalEvent = isGlobalEvent
    )

    class BadGateway(
        code: String,
        message: String,
        throwable: Throwable,
        isGlobalEvent: Boolean
    ): DataError(
        code = code,
        message = message,
        cause = throwable,
        isGlobalEvent = isGlobalEvent
    )

    class Generic(
        code: String,
        message: String,
        isGlobalEvent: Boolean
    ): DataError(
        code = code,
        message = message,
        cause = null,
        isGlobalEvent = isGlobalEvent
    )

    class Offline(
        code: String = "01404",
        message: String = "",
        isGlobalEvent: Boolean
    ): DataError(
        code = code,
        message = message,
        isGlobalEvent = isGlobalEvent
    )

    class AirplaneMode(
        code: String = "01405",
        message: String = "",
        isGlobalEvent: Boolean
    ): DataError(
        code = code,
        message = message,
        isGlobalEvent = isGlobalEvent
    )

    class SSLError(
        message: String? = null,
        cause: Throwable? = null,
        isGlobalEvent: Boolean
    ): DataError(
        message = message,
        cause = cause,
        isGlobalEvent = isGlobalEvent
    )

    companion object {
        private const val GENERAL_ERROR = "7002"
    }

}