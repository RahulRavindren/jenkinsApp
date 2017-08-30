package com.app.network

import android.content.Context
import com.app.jenkins_common.utils.NetworkUtils
import com.app.network.interceptors.BaseHeaderInterceptor
import com.app.network.interceptors.CacheControlInterceptor
import com.app.network.interceptors.ConnectivityInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitBuilder @Inject constructor(private var mContext: Context,
                                          private var networkUtils: NetworkUtils) {

    private fun getCacheDir(context: Context): Cache {
        return Cache(context.cacheDir, 10);
    }

    private fun getOkHttpClient(): OkHttpClient {
        var client: OkHttpClient = OkHttpClient()
        return client.newBuilder()
                .cache(getCacheDir(mContext))
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(BaseHeaderInterceptor())
                .addInterceptor(ConnectivityInterceptor(networkUtils))
                .addInterceptor(CacheControlInterceptor(networkUtils))
                .build()
    }

    fun getRetrofitBuilder(): Retrofit {
        var builder: Retrofit = Retrofit.Builder()
                .baseUrl("").client(getOkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()
        return builder

    }


}
