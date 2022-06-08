package com.burhan.karakurt.weekend.common.base.data

sealed class State<out T> {

    class Success<T>(val data: T) : State<T>()

    class Error(val exception: Throwable) : State<Nothing>()

    object Loading : State<Nothing>()
}
