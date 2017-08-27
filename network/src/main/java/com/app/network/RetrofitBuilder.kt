package com.app.network

import android.content.Context
import com.app.jenkins_common.utils.NetworkUtils
import com.app.network.interceptors.BaseHeaderInterceptor
import com.app.network.interceptors.ConnectivityInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitBuilder {
    private var mContext: Context

    constructor(mContext: Context) {
        this.mContext = mContext
    }

    companion object {
        private var INSTANCE: RetrofitBuilder? = null

        fun getInstance(context: Context): RetrofitBuilder {
            if (INSTANCE == null) {
                synchronized(RetrofitBuilder.javaClass) {
                    if (INSTANCE == null) {
                        INSTANCE = RetrofitBuilder(context)
                    }
                }
            }
            return INSTANCE!!
        }
    }

    private fun getCacheDir(context: Context): Cache {
        return Cache(context.cacheDir, 10);
    }

    private fun getOkHttpClient(): OkHttpClient {
        var client: OkHttpClient = OkHttpClient()
        return client.newBuilder()
                .cache(getCacheDir(mContext))
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(BaseHeaderInterceptor())
                .addInterceptor(ConnectivityInterceptor(NetworkUtils())).build()
    }

    fun getRetrofitBuilder(): Retrofit {
        var builder: Retrofit = Retrofit.Builder()
                .baseUrl("").client(getOkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()
        return builder

    }


}
