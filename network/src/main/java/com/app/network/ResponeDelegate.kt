package com.app.network

import com.app.network.errorhandlers.BaseException
import retrofit2.Call
import retrofit2.Response

interface ResponeDelegate<T> {
    fun onResponse(call: Call<T>, reponse: Response<T>);
    fun onError(call: Call<T>, exception: BaseException?);
}