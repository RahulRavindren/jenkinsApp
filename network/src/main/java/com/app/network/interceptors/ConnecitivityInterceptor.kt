package com.app.network.interceptors


import com.app.jenkins_common.utils.NetworkUtils
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class ConnecitivityInterceptor @Inject
constructor(private val connectivityManager: NetworkUtils) : Interceptor {


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response? {
        if (connectivityManager.isOnline) {
            return null
        }
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }
}
