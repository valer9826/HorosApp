package pe.com.interbank.mobilebanking.domain.common.entities

sealed class DataResult<out T> {
    data class Success<out T>(
        val data: T
    ): DataResult<T>()
    open class Error(
        val code: String? = "",
        val message: String? = null,
        val cause: Throwable? = null,
        val isGlobalEvent: Boolean
    ): DataResult<Nothing>()
}