package com.app.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponseCallBack<T> constructor(private val delegate: ResponeDelegate<T>) : Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
        assertResponseNull(response)
        assertResponseSuccess(response)
        delegate.onResponse(call, response)
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        delegate.onError(call, null);
    }

    private fun assertResponseNull(respone: Response<T>?) {
        assert(respone != null);
    }

    private fun assertResponseSuccess(respone: Response<T>?) {
        assert(respone!!.isSuccessful)
    }

}
