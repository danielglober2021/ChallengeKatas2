package com.example.challengekatas2.utils

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val errorMessage: String?) : Result<Nothing>()

    fun handleResult(
        onSuccess: (T) -> Unit = {},
        onError: (String?) -> Unit = {},
        onLoading: () -> Unit = {}
    ) {
        when (this) {
            is Success -> onSuccess(data)
            is Error -> onError(errorMessage)
            is Loading -> onLoading()
            else -> {
            }
        }
    }
}