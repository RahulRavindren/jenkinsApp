package com.app.network.dagger

import dagger.Subcomponent
import retrofit2.Retrofit

@Subcomponent(modules = arrayOf(NetworkModule::class))
interface NetworkSubComponent {
    fun retrofit(): Retrofit

    @Subcomponent.Builder
    interface Builder {
        fun networkModule(networkModule: NetworkModule)
        fun build(): NetworkSubComponent
    }
}