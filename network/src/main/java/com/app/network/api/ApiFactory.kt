package com.app.network.api

import com.app.network.RetrofitBuilder
import javax.inject.Inject

class ApiFactory @Inject constructor(var retrofitBuilder: RetrofitBuilder) {
    inline fun <reified T : Any> createApiService(): T? {
        return retrofitBuilder.getRetrofitBuilder().create(T::class.java)
    }
}