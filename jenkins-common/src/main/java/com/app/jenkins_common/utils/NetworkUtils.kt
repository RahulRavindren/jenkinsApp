package com.app.jenkins_common.utils


import android.content.Intent
import javax.inject.Singleton

@Singleton
class NetworkUtils {
    private var intent: Intent? = null

    constructor(intent: Intent) {
        this.intent = intent
        init()
    }

    constructor() {

    }

    private fun init() {
        if (intent != null) {

        }
    }

    val isOnline: Boolean
        get() = false
}
