package com.app.network.interceptors

import com.app.jenkins_common.utils.NetworkUtils
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class CacheControlInterceptor @Inject constructor(private val networkUtils: NetworkUtils) : Interceptor {
    companion object {
        private var CACHE_MAX_AGE = 10;
    }

    override fun intercept(chain: Interceptor.Chain?): Response {
        var originalResponse: Response = chain!!.proceed(chain.request());
        if (networkUtils.isOnline) {
            return originalResponse
                    .newBuilder()
                    .addHeader("Cache-Control", "public, max-age=" + CACHE_MAX_AGE)
                    .build()
        } else {
            var maxstale = 60 * 60 * 24
            return originalResponse
                    .newBuilder()
                    .addHeader("Cache-Control", "public, only-if-cached, max-stale=" + maxstale)
                    .build()
        }
    }
}