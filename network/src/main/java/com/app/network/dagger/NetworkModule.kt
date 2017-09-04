package com.app.network.dagger

import android.content.Context
import com.app.jenkins_common.utils.NetworkUtils
import com.app.network.RetrofitBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class NetworkModule constructor(private var context: Context) {

    @Provides
    fun providesRetrofit(context: Context, networkUtils: NetworkUtils): Retrofit {
        return RetrofitBuilder(context, networkUtils).getRetrofitBuilder()
    }

    @Provides
    fun providesNetworkUtils(): NetworkUtils {
        return NetworkUtils()
    }
}