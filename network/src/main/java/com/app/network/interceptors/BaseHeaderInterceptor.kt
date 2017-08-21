package com.app.network.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class BaseHeaderInterceptor : Interceptor {
    val baseHeaders = arrayOf("Content-Type: application/json", "Accept: application/json");

    override fun intercept(chain: Interceptor.Chain?): Response? {
        var request: Request? = chain?.request();
        return chain?.proceed(request);
    }
}