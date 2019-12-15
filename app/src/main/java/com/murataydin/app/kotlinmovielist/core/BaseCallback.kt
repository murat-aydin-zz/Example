package com.murataydin.app.kotlinmovielist.core

interface BaseCallBack<T> {
    fun onSuccess(data: T)
    fun onFail(message: String)
}