package com.app.jenkins_common.utils

import timber.log.Timber

class LoggerUtils {

    fun debug(key: String, message: String) {
        Timber.d(key + " : " + message)
    }

    fun debug(message: String, vararg args: Object) {
        Timber.d(message, args)
    }

    fun debug(throwable: Throwable) {
        Timber.d(throwable);
    }

    fun error(key: String, message: String) {
        Timber.d(key + " : " + message)
    }

    fun error(message: String, vararg args: Object) {
        Timber.d(message, args)
    }

    fun error(throwable: Throwable) {
        Timber.d(throwable);
    }

    fun info(key: String, message: String) {
        Timber.d(key + " : " + message)
    }

    fun info(message: String, vararg args: Object) {
        Timber.d(message, args)
    }

    fun info(throwable: Throwable) {
        Timber.d(throwable);
    }
}