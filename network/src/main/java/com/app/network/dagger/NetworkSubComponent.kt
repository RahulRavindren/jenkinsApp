package com.app.network.dagger

import dagger.Subcomponent

@Subcomponent(modules = arrayOf(NetworkModule::class))
interface NetworkSubComponent {

}